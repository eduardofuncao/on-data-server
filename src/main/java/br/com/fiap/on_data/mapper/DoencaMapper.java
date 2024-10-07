package br.com.fiap.on_data.mapper;

import br.com.fiap.on_data.controller.DTO.DoencaDTO;
import br.com.fiap.on_data.model.Doenca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoencaMapper {
    @Mapping(source = "idDoenca", target = "idDoenca")
    DoencaDTO DoencaToDTO(Doenca Doenca);

    @Mapping(source = "idDoenca", target = "idDoenca")
    Doenca DoencaFromDTO(DoencaDTO DoencaDTO);
}
