package org.example.service;

import org.example.DTO.CreateSocioDTO;
import org.example.DTO.UpdateSocioDTO;
import org.example.entities.Socio;
import org.example.repository.SocioRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocioService {

    private final SocioRepositoryInterface SRepository;

    @Autowired
    public SocioService(SocioRepositoryInterface socioRepository) {
        this.SRepository = socioRepository;
    }


    public Socio cadastrarSocio(CreateSocioDTO socio) {
        Socio Nsocio = new Socio(socio.getNome(), socio.getDocumento());

        return SRepository.cadastrar(Nsocio);
    }

    public Socio buscarPorDocumento(String documento) {
        return SRepository.buscarPorDocumento(documento).orElseThrow(() -> new RuntimeException("Socio não encontrado"));
    }

    public Socio buscarPorNumero(String numero) {
        return SRepository.buscarPorNumero(numero).orElseThrow(() -> new RuntimeException("Socio não encontrado"));
    }

    public Socio atualizarSocio(String numero, UpdateSocioDTO socio) {

        Socio Upsocio = SRepository.buscarPorNumero(numero).orElseThrow(() -> new RuntimeException("Socio não encontrado"));

        Upsocio.setNome(socio.getNome());
        Upsocio.setDocumento(socio.getDocumento());

        return SRepository.atualizar(Upsocio);

    }

    public void cancelarSocio(String numero) {
        Socio Csocio = SRepository.buscarPorNumero(numero).orElseThrow(() -> new RuntimeException("Socio não encontrado"));
        SRepository.cancelar(Csocio);
    }

}
