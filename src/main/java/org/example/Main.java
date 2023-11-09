package org.example;

import org.example.entities.DTO.CreateSocioDTO;
import org.example.entities.DTO.UpdateSocioDTO;
import org.example.entities.Socio;
import org.example.presentation.Menu;
import org.example.repository.SocioRepositoryJSON;
import org.example.service.SocioService;


public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.start();

    }

}