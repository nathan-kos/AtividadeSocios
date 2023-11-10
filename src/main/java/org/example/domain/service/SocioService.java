package org.example.domain.service;

import org.example.presentation.DTO.CreateSocioDTO;
import org.example.presentation.DTO.UpdateSocioDTO;
import org.example.data.entities.Socio;
import org.example.data.repository.SocioRepositoryInterface;
import org.example.util.NotFoundException;


import java.util.ArrayList;
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

        Socio eSocio = SRepository.buscarPorDocumento(socio.getDocumento()).orElse(null);

        if (eSocio != null && !eSocio.getNumero().equals(numero)) {
            throw new RuntimeException("Socio já cadastrado");
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

    @Override
    public ArrayList<Socio> listarSocios() {
        return SRepository.listar();
    }
}
