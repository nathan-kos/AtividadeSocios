package org.example.service;

import org.example.entities.DTO.CreateSocioDTO;
import org.example.entities.DTO.UpdateSocioDTO;
import org.example.entities.Socio;
import org.example.repository.SocioRepositoryInterface;
import org.example.repository.SocioRepositoryJSON;
import org.example.util.NotFoundException;


import java.util.Optional;


public class SocioService implements SocioServiceInterface {

    private final SocioRepositoryInterface SRepository;

    public SocioService(SocioRepositoryInterface socioRepository) {
        this.SRepository = socioRepository;
    }


    @Override
    public Socio cadastrarSocio(CreateSocioDTO socio) {

        Optional<Socio> eSocio = SRepository.buscarPorDocumento(socio.getDocumento());

        if (eSocio.isPresent()) {
            throw new RuntimeException("Socio já cadastrado");
        }

        Socio Nsocio = new Socio(socio.getNome(), socio.getDocumento());

        return SRepository.cadastrar(Nsocio);
    }

    @Override
    public Socio buscarPorDocumento(String documento) throws NotFoundException {
        return SRepository.buscarPorDocumento(documento).orElseThrow(() -> new NotFoundException("Socio não encontrado"));
    }

    @Override
    public Socio buscarPorNumero(String numero) throws NotFoundException {
        return SRepository.buscarPorNumero(numero).orElseThrow(() -> new NotFoundException("Socio não encontrado"));
    }

    @Override
    public Socio atualizarSocio(String numero, UpdateSocioDTO socio) throws NotFoundException {

        Socio Upsocio = SRepository.buscarPorNumero(numero).orElseThrow(() -> new NotFoundException("Socio não encontrado"));

        if(socio.getNome() != null) {
            Upsocio.setNome(socio.getNome());
        }
        if (socio.getDocumento() != null) {
            Upsocio.setDocumento(socio.getDocumento());
        }

        return SRepository.atualizar(Upsocio);

    }

    @Override
    public void cancelarSocio(String numero) throws NotFoundException {
        Socio Csocio = SRepository.buscarPorNumero(numero).orElseThrow(() -> new NotFoundException("Socio não encontrado"));
        SRepository.cancelar(Csocio);
    }

}
