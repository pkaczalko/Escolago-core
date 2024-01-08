package com.escolago.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class StorageController {
    private final StorageService storageService;
    @Autowired
    StorageController(StorageService storageService){
        this.storageService = storageService;
    }

    @PostMapping("/asset/{id}/upload")
    public ResponseEntity<?> uploadFile(@PathVariable String id,@RequestParam("file") MultipartFile file) throws IOException {
        String uploadFile = this.storageService.uploadFile(file,id);
        return ResponseEntity.status(HttpStatus.CREATED).body(new FileResponse(uploadFile));
    }

    @GetMapping("/asset/{id}/file/{name}")
    public ResponseEntity<?> getFile(@PathVariable("name") String name) throws IOException {
        FileData fileData = this.storageService.getFileData(name).orElse(null);
        if(fileData == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(fileData.getType()))
                .body(Files.readAllBytes(new File(fileData.getLocalPath()).toPath()));
    }


}
