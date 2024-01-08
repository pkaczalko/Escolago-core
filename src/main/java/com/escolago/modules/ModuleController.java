package com.escolago.modules;

import com.escolago.MapStructMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
