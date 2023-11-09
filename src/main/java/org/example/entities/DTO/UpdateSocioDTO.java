package org.example.entities.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSocioDTO {

    private String nome;
    private String documento;

    public UpdateSocioDTO(String nome, String documento) {
        setNome(nome);
        setDocumento(documento);
    }

}
