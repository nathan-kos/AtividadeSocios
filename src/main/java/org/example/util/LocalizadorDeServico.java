package org.example.util;

import org.example.data.repository.SocioRepositoryInterface;
import org.example.data.repository.SocioRepositoryJSON;
import org.example.domain.service.SocioService;
import org.example.domain.service.SocioServiceInterface;

public class LocalizadorDeServico {

    public  SocioRepositoryInterface socioRepository(){
        return new SocioRepositoryJSON();
    }

    public  SocioServiceInterface socioService(){
        return new SocioService(socioRepository());
    }

}
