package org.example.entities.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSocioDTO {

    private String nome;
    private String documento;

    public CreateSocioDTO(String nome, String documento) {
        setNome(nome);
        setDocumento(documento);
    }
}
