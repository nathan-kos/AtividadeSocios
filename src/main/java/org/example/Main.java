package org.example;

import org.example.entities.DTO.CreateSocioDTO;
import org.example.entities.DTO.UpdateSocioDTO;
import org.example.entities.Socio;
import org.example.repository.SocioRepositoryJSON;
import org.example.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    @Autowired
    private SocioService socioService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    public void init() {

        try {
            Socio socio1 = socioService.buscarPorNumero("ac4bbde0-4878-4193-82c1-e1140d84ac37");
            System.out.println(socio1.getNome() + "2");
            System.out.println(socio1.getNumero() + "2");
            System.out.println(socio1.getDocumento() + "2");
            System.out.println(socio1.getDataInscricao() + "2");
        } catch (Exception e) {
            System.out.println(e.getMessage()+ "3");
        }


        try {
        Socio socio2 = socioService.atualizarSocio("ac4bbde0-4878-4193-82c1-e1140d84ac37", new UpdateSocioDTO(null, "1234567890"));
        }catch (Exception e) {
            System.out.println(e.getMessage()+ "2");
        }



        try {
            Socio socio3 = socioService.buscarPorNumero("ac4bbde0-4878-4193-82c1-e1140d84ac37");
            System.out.println(socio3.getNome());
            System.out.println(socio3.getNumero());
            System.out.println(socio3.getDocumento());
            System.out.println(socio3.getDataInscricao());
        } catch (Exception e) {
            System.out.println(e.getMessage()+ "1");
        }

    }
}