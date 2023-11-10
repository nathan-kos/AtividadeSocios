package org.example.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    private Socio(@JsonProperty("numero") String numero,
                 @JsonProperty("nome") String nome,
                 @JsonProperty("dataInscricao") LocalDate dataInscricao,
                 @JsonProperty("documento") String documento) {
        this.numero = numero;
        this.nome = nome;
        this.dataInscricao = dataInscricao;
        this.documento = documento;
    }

}
