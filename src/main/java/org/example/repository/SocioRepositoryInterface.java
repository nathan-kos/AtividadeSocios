package org.example.repository;

import org.example.entities.Socio;

import java.util.Optional;

public interface SocioRepositoryInterface {

    Socio cadastrar(Socio socio);

    void cancelar(Socio socio);

    Optional<Socio> buscarPorDocumento(String documento);

    Optional<Socio> buscarPorNumero(String numero);

    Socio atualizar(Socio socio);

}
