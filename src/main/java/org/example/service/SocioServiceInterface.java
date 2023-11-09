package org.example.service;

import org.example.entities.DTO.CreateSocioDTO;
import org.example.entities.DTO.UpdateSocioDTO;
import org.example.entities.Socio;
import org.example.util.NotFoundException;

import java.util.ArrayList;

public interface SocioServiceInterface {
    Socio cadastrarSocio(CreateSocioDTO socio);

    Socio buscarPorDocumento(String documento) throws NotFoundException;

    Socio buscarPorNumero(String numero) throws NotFoundException;

    Socio atualizarSocio(String numero, UpdateSocioDTO socio) throws NotFoundException;

    void cancelarSocio(String numero) throws NotFoundException;

    ArrayList<Socio> listarSocios();
}
