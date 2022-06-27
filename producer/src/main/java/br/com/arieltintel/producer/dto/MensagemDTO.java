package br.com.arieltintel.producer.dto;

import java.io.Serializable;


public class MensagemDTO implements Serializable {
    private String texto;

    public MensagemDTO() {
    }

    public MensagemDTO(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
