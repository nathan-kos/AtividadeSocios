package org.example.data.repository;

import org.example.data.entities.Socio;

import java.util.ArrayList;
import java.util.Optional;

public interface SocioRepositoryInterface {

    Socio cadastrar(Socio socio);

    void deletar(Socio socio);

    Optional<Socio> buscarPorDocumento(String documento);

    Optional<Socio> buscarPorNumero(String numero);

    Socio atualizar(Socio socio);

    ArrayList<Socio> listar();

}
