package com.escolago.modules;

import com.escolago.library.mappers.MapStructMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
public class ModuleController {

    ModuleRepository moduleRepository;
    MapStructMapper mapper;
    ModuleController(ModuleRepository moduleRepository, MapStructMapper mapper){
        this.moduleRepository = moduleRepository;
        this.mapper = mapper;
    }

    @GetMapping("/modules")
    ResponseEntity<?> getModules(){
        return ResponseEntity.ok(
                mapper.modulesToDTO(
                         this.moduleRepository.findAll()
                ));
    }


}
