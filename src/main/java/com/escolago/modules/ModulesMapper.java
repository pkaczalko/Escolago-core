package com.escolago.modules;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ModulesMapper {
    ModulesDTO moduleToDTO(Modules module);
    Modules DTOtoModule(ModulesDTO module);

    @Mapping(source = "link",target = "link")
    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    List<ModulesDTO> modulesToDTO(List<Modules> m);
    List<Modules> DTOsToModules(List<ModulesDTO> m);
}
