package org.example.repository;

import org.example.entities.Socio;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SocioRepositoryJSON implements SocioRepositoryInterface{

    @Override
    public Socio cadastrar(Socio socio) {
        return null;
    }

    @Override
    public void cancelar(Socio socio) {

    }

    @Override
    public Socio atualizar(Socio socio) {
        return null;
    }

    @Override
    public Optional<Socio> buscarPorDocumento(String documento) {
        return null;
    }

    @Override
    public Optional<Socio> buscarPorNumero(String numero) {
        return null;
    }

}
