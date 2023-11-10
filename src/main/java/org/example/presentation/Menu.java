package org.example.presentation;

import org.example.presentation.DTO.CreateSocioDTO;
import org.example.presentation.DTO.UpdateSocioDTO;
import org.example.data.entities.Socio;
import org.example.domain.service.SocioServiceInterface;
import org.example.util.LocalizadorDeServico;

import java.util.Scanner;

public class Menu {

    public void start() {

        boolean continuar = true;

        while (continuar) {

            System.out.printf("%n%n%n%n");
            System.out.println("Bem vindo ao sistema de sócios do clube");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar sócio");
            System.out.println("2 - Cancelar sócio");
            System.out.println("3 - Buscar sócio por documento");
            System.out.println("4 - Buscar sócio por número");
            System.out.println("5 - Atualizar sócio");
            System.out.println("6 - Listar sócios");
            System.out.println("7 - Sair");

            int opcao = 0;

            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarSocio();
                    break;
                case 2:
                    cancelarSocio();
                    break;
                case 3:
                    buscarSocioPorDocumento();
                    break;
                case 4:
                    buscarSocioPorNumero();
                    break;
                case 5:
                    atualizarSocio();
                    break;
                case 6:
                    listarSocios();
                    break;
                case 7:
                    System.out.println("Até logo!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private void atualizarSocio() {

            System.out.println("Digite o número do sócio:");
            Scanner scanner = new Scanner(System.in);
            String numero = scanner.nextLine();

            System.out.println("Digite o nome do sócio ou deixe em branco para não atualizar:");
            String nome = scanner.nextLine();
            if(nome.isEmpty()){
                nome = null;
            }

            System.out.println("Digite o documento do sócio ou deixe em branco para não atualizar:");
            String documento = scanner.nextLine();

            if(documento.isEmpty()){
                documento = null;
            }

            try {
                SocioServiceInterface socioService = new LocalizadorDeServico().socioService();
                Socio socio = socioService.atualizarSocio(numero, new UpdateSocioDTO(nome, documento));
                System.out.println("Sócio atualizado com sucesso!");
                System.out.printf("Nome: %s%n", socio.getNome());
                System.out.printf("Documento: %s%n", socio.getDocumento());
                System.out.printf("Número: %s%n", socio.getNumero());
                System.out.printf("Data de cadastro: %s%n", socio.getDataInscricao());
            } catch (Exception e) {
                System.out.println("Erro ao atualizar sócio: " + e.getMessage());
            }
    }

    private void buscarSocioPorNumero() {

        System.out.println("Digite o número do sócio:");
        Scanner scanner = new Scanner(System.in);
        String numero = scanner.nextLine();

        try {
            SocioServiceInterface socioService = new LocalizadorDeServico().socioService();
            Socio socio = socioService.buscarPorNumero(numero);
            System.out.println("Sócio encontrado:");
            System.out.printf("Nome: %s%n", socio.getNome());
            System.out.printf("Documento: %s%n", socio.getDocumento());
            System.out.printf("Número: %s%n", socio.getNumero());
            System.out.printf("Data de cadastro: %s%n", socio.getDataInscricao());
        } catch (Exception e) {
            System.out.println("Erro ao buscar sócio: " + e.getMessage());
        }
    }

    private void buscarSocioPorDocumento() {

        System.out.println("Digite o documento do sócio:");
        Scanner scanner = new Scanner(System.in);
        String documento = scanner.nextLine();

        try {
            SocioServiceInterface socioService = new LocalizadorDeServico().socioService();
            Socio socio = socioService.buscarPorDocumento(documento);
            System.out.println("Sócio encontrado:");
            System.out.printf("Nome: %s%n", socio.getNome());
            System.out.printf("Documento: %s%n", socio.getDocumento());
            System.out.printf("Número: %s%n", socio.getNumero());
            System.out.printf("Data de cadastro: %s%n", socio.getDataInscricao());
        } catch (Exception e) {
            System.out.println("Erro ao buscar sócio: " + e.getMessage());
        }
    }

    private void cancelarSocio() {

        System.out.println("Digite o número do sócio:");
        Scanner scanner = new Scanner(System.in);
        String numero = scanner.nextLine();

        try {
            SocioServiceInterface socioService = new LocalizadorDeServico().socioService();
            socioService.cancelarSocio(numero);
            System.out.println("Sócio cancelado com sucesso!");
        }catch (Exception e) {
            System.out.println("Erro ao cancelar sócio: " + e.getMessage());
        }
    }

    public void cadastrarSocio(){
        System.out.println("Digite o nome do sócio:");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        System.out.println("Digite o documento do sócio:");
        String documento = scanner.nextLine();

        SocioServiceInterface socioService = new LocalizadorDeServico().socioService();

        try {
            Socio socio = socioService.cadastrarSocio(new CreateSocioDTO(nome, documento));
            System.out.println("Sócio cadastrado com sucesso!");
            System.out.printf("Nome: %s%n", socio.getNome());
            System.out.printf("Documento: %s%n", socio.getDocumento());
            System.out.printf("Número: %s%n", socio.getNumero());
            System.out.printf("Data de cadastro: %s%n", socio.getDataInscricao());
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar sócio: " + e.getMessage());
        }
    }

    public void listarSocios(){
        SocioServiceInterface socioService = new LocalizadorDeServico().socioService();
        try {
            for (Socio socio : socioService.listarSocios()) {
                System.out.printf("Nome: %s%n", socio.getNome());
                System.out.printf("Documento: %s%n", socio.getDocumento());
                System.out.printf("Número: %s%n", socio.getNumero());
                System.out.printf("Data de cadastro: %s%n%n", socio.getDataInscricao());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar sócios: " + e.getMessage());
        }
    }

}
