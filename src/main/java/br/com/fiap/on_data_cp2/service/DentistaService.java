package br.com.fiap.on_data_cp2.service;

import br.com.fiap.on_data_cp2.controller.dto.DentistaDTO;
import br.com.fiap.on_data_cp2.entity.Clinica;
import br.com.fiap.on_data_cp2.entity.Dentista;
import br.com.fiap.on_data_cp2.exception.DentistaDuplicadoException;
import br.com.fiap.on_data_cp2.exception.NaoEncontradoException;
import br.com.fiap.on_data_cp2.repository.ClinicaRepository;
import br.com.fiap.on_data_cp2.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DentistaService {

    @Autowired
    private DentistaRepository dentistaRepository;

    @Autowired
    private ClinicaRepository clinicaRepository;

    public DentistaDTO criarDentista(DentistaDTO dentistaDTO) {
        Dentista dentista = convertToEntity(dentistaDTO);

        // checando se há outro dentista com o mesmo registro
        if (dentista.getRegistro() != null && !dentista.getRegistro().isEmpty()) {
            Optional<Dentista> existingOcorrencia = dentistaRepository.findByRegistro(dentista.getRegistro());

            if (existingOcorrencia.isPresent()) {
                throw new DentistaDuplicadoException("Dentista com número de registro " + dentista.getRegistro() + " já existe.");
            }
        }

        Clinica clinica = clinicaRepository.findById(dentistaDTO.getClinicaId())
                .orElseThrow(() -> new NaoEncontradoException("Clínica não encontrada"));
        dentista.setClinica(clinica);

        Dentista savedDentista = dentistaRepository.save(dentista);
        dentistaDTO.setId(savedDentista.getId());
        return dentistaDTO;
    }

    public Page<DentistaDTO> listarDentistas(Pageable pageable) {
        return dentistaRepository.findAll(pageable).map(this::convertToDTO);
    }

    public DentistaDTO buscarDentistaPorId(Long id) {
        Dentista foundDentista = dentistaRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Clínica não encontrada"));
        return convertToDTO(foundDentista);
    }

    public void deletarDentista(Long id) {dentistaRepository.deleteById(id);}

    private DentistaDTO convertToDTO(Dentista dentista) {
        DentistaDTO dentistaDTO = new DentistaDTO();
        dentistaDTO.setId(dentista.getId());
        dentistaDTO.setNome(dentista.getNome());
        dentistaDTO.setIdade(dentista.getIdade());
        dentistaDTO.setRegistro(dentista.getRegistro());
        dentistaDTO.setSalario(dentista.getSalario());

        return dentistaDTO;
    }

    private Dentista convertToEntity(DentistaDTO dentistaDTO) {
        Dentista dentista = new Dentista();
        dentista.setNome(dentistaDTO.getNome());
        dentista.setIdade(dentistaDTO.getIdade());
        dentista.setRegistro(dentistaDTO.getRegistro());
        dentista.setSalario(dentistaDTO.getSalario());

        return dentista;
    }
}