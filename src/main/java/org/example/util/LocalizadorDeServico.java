package org.example.util;

import org.example.repository.SocioRepositoryInterface;
import org.example.repository.SocioRepositoryJSON;
import org.example.service.SocioService;
import org.example.service.SocioServiceInterface;

public class LocalizadorDeServico {

    public static SocioRepositoryInterface socioRepository(){
        return new SocioRepositoryJSON();
    }

    public static SocioServiceInterface socioService(){
        return new SocioService(socioRepository());
    }

}
