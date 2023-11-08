package org.example.service;

import org.example.entities.DTO.CreateSocioDTO;
import org.example.entities.DTO.UpdateSocioDTO;
import org.example.entities.Socio;
import org.example.repository.SocioRepositoryInterface;
import org.example.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocioService {

    private final SocioRepositoryInterface SRepository;

    public SocioService(SocioRepositoryInterface socioRepository) {
        this.SRepository = socioRepository;
    }


    public Socio cadastrarSocio(CreateSocioDTO socio) {
        Socio Nsocio = new Socio(socio.getNome(), socio.getDocumento());

        return SRepository.cadastrar(Nsocio);
    }

    public Socio buscarPorDocumento(String documento) throws NotFoundException {
        return SRepository.buscarPorDocumento(documento).orElseThrow(() -> new NotFoundException("Socio não encontrado"));
    }

    public Socio buscarPorNumero(String numero) throws NotFoundException {
        return SRepository.buscarPorNumero(numero).orElseThrow(() -> new NotFoundException("Socio não encontrado"));
    }

    public Socio atualizarSocio(String numero, UpdateSocioDTO socio) throws NotFoundException {

        Socio Upsocio = SRepository.buscarPorNumero(numero).orElseThrow(() -> new NotFoundException("Socio não encontrado"));

        Upsocio.setNome(socio.getNome());
        Upsocio.setDocumento(socio.getDocumento());

        return SRepository.atualizar(Upsocio);

    }

    public void cancelarSocio(String numero) throws NotFoundException {
        Socio Csocio = SRepository.buscarPorNumero(numero).orElseThrow(() -> new NotFoundException("Socio não encontrado"));
        SRepository.cancelar(Csocio);
    }

}
