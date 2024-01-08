package com.escolago.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class StorageService {

    private final FileDataRepository fileDataRepository;
    @Autowired
    StorageService(FileDataRepository fileDataRepository){
        this.fileDataRepository = fileDataRepository;
    }

    private final String FOLDER = "C:\\Users\\Piotrek\\IdeaProjects\\escolago-core\\src\\main\\resources\\static\\files\\";


    public String uploadFile(MultipartFile file,String asset_id) throws IOException {
        String fileName = URLEncoder.encode(Objects.requireNonNull(file.getOriginalFilename()), StandardCharsets.UTF_8);
        String LocalFilePath = FOLDER+asset_id+'\\'+fileName;
        String RemoteFilePath = "http://localhost:8080/asset/"+asset_id+"/file/"+fileName;
        try {
            Path folderPath = Paths.get(LocalFilePath);
            if (Files.notExists(folderPath)) {
                Files.createDirectories(folderPath);
                System.out.println("Utworzono folder: " + LocalFilePath);
            } else {
                System.out.println("Folder "+LocalFilePath+" już istnieje.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        FileData fileData = fileDataRepository.findByName(file.getOriginalFilename())
                .orElse(FileData.builder()
                             .name(file.getOriginalFilename())
                             .type(file.getContentType())
                             .RemotePath(RemoteFilePath)
                             .LocalPath(LocalFilePath)
                             .build());



        try {
            file.transferTo(new File(LocalFilePath));
            return fileDataRepository.save(fileData).getRemotePath();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public Optional<FileData> getFileData(String name) throws IOException, NoSuchElementException {
       return fileDataRepository.findByName(URLDecoder.decode(name, StandardCharsets.UTF_8));
    }



}
