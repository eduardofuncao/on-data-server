package br.com.fiap.on_data.mapper;

import br.com.fiap.on_data.controller.DTO.OcorrenciaDTO;
import br.com.fiap.on_data.model.Doenca;
import br.com.fiap.on_data.model.Ocorrencia;
import br.com.fiap.on_data.model.Paciente;

public class OcorrenciaMapper {


    public OcorrenciaDTO ocorrenciaToOcorrenciaDto(Ocorrencia ocorrencia){
        OcorrenciaDTO ocorrenciaDto = new OcorrenciaDTO();
        ocorrenciaDto.setCodigoOcorrencia(ocorrencia.getCodigoOcorrencia());
        ocorrenciaDto.setData(ocorrencia.getData());
        ocorrenciaDto.setValor(ocorrencia.getValor());
        ocorrenciaDto.setDuracao(ocorrencia.getDuracao());
        ocorrenciaDto.setAprovado(ocorrencia.isAprovado());
        ocorrenciaDto.setIdDoenca(ocorrencia.getDoenca().getIdDoenca());
        ocorrenciaDto.setIdPaciente(ocorrencia.getPaciente().getId());
        return ocorrenciaDto;
    }

    public Ocorrencia ocorrenciaDtoToOcorrencia(OcorrenciaDTO ocorrenciaDTO, Paciente paciente, Doenca doenca) {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setCodigoOcorrencia(ocorrenciaDTO.getCodigoOcorrencia());
        ocorrencia.setData(ocorrenciaDTO.getData());
        ocorrencia.setValor(ocorrenciaDTO.getValor());
        ocorrencia.setDuracao(ocorrenciaDTO.getDuracao());
        ocorrencia.setAprovado(ocorrencia.isAprovado());
        ocorrencia.setPaciente(paciente);
        ocorrencia.setDoenca(doenca);
        return ocorrencia;
    }
}
