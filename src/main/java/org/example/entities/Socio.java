package org.example.entities;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Socio {

    private String numero;
    private String nome;

    private LocalDate dataInscricao;

    private String documento;

    public Socio(String nome, String documento) {
        setNome(nome);
        setDocumento(documento);
        setDataInscricao(LocalDate.now());
    }

}
