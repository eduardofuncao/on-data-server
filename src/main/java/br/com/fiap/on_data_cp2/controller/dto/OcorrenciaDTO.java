package br.com.fiap.on_data_cp2.controller.dto;

import java.time.LocalDateTime;

public class OcorrenciaDTO {
    private long id;
    private LocalDateTime data;

    private String codigoOcorrencia;

    private double valor;

    private int duracaoHoras;

    private long pacienteId;

    private long doencaId;

    private long dentistaId;

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoOcorrencia() {
        return codigoOcorrencia;
    }

    public void setCodigoOcorrencia(String codigoOcorrencia) {
        this.codigoOcorrencia = codigoOcorrencia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    public long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public long getDoencaId() {
        return doencaId;
    }

    public void setDoencaId(long doencaId) {
        this.doencaId = doencaId;
    }

    public long getDentistaId() {
        return dentistaId;
    }

    public void setDentistaId(long dentistaId) {
        this.dentistaId = dentistaId;
    }
}
