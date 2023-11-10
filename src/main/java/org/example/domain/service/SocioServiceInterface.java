package org.example.domain.service;

import org.example.presentation.DTO.CreateSocioDTO;
import org.example.presentation.DTO.UpdateSocioDTO;
import org.example.data.entities.Socio;
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
