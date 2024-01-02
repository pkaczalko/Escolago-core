package com.escolago.modules;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
public class ModuleController {

    ModuleRepository moduleRepository;
    ModulesMapper mapper;
    ModuleController(ModuleRepository moduleRepository, ModulesMapper mapper){
        this.moduleRepository = moduleRepository;
        this.mapper = mapper;
    }

    @GetMapping("/modules")
    ResponseEntity<?> getModules(){
        return ResponseEntity.ok(
                mapper.modulesToDTO(
                        (List<Modules>) this.moduleRepository.findAll()
                ));
    }


}
