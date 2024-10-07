package br.com.fiap.on_data.mapper;

import br.com.fiap.on_data.controller.DTO.PacienteDTO;
import br.com.fiap.on_data.model.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    @Mapping(source = "id", target = "id")
    PacienteDTO PacienteToDTO(Paciente Paciente);

    @Mapping(source = "id", target = "id")
    Paciente PacienteFromDTO(PacienteDTO PacienteDTO);
}
