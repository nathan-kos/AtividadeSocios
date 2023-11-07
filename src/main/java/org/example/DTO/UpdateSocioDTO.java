package org.example.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSocioDTO {

    private String nome;
    private String documento;

    UpdateSocioDTO(String nome, String documento) {
        setNome(nome);
        setDocumento(documento);
    }


}
