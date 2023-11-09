package org.example.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.entities.Socio;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

public class SocioRepositoryJSON implements SocioRepositoryInterface{

    private final File file;
    private final ObjectMapper mapper;

    public SocioRepositoryJSON() {
        this.file = new File("socios.json");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                throw new RuntimeException("Não foi possível criar o arquivo");
            }
        }

        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public Socio cadastrar(Socio socio) {

        socio.setNumero(UUID.randomUUID().toString());

        try {
            JsonNode jsonNode = mapper.readTree(file);
            if (!jsonNode.isArray()) {
                jsonNode = mapper.createArrayNode();
            }

            ((ArrayNode) jsonNode).add(mapper.valueToTree(socio));
            mapper.writeValue(file, jsonNode);
            return socio;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Não foi possível escrever no arquivo");
        }
    }

    @Override
    public void cancelar(Socio socio) {
        try {
            JsonNode jsonNode = mapper.readTree(file);
            Iterator<JsonNode> elements = jsonNode.elements();
            while (elements.hasNext()) {
                JsonNode element = elements.next();
                if (element.get("numero").asText().equals(socio.getNumero())) {
                    elements.remove();
                }
            }
            mapper.writeValue(file, jsonNode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Não foi possível remover o objeto do arquivo");
        }
    }

    @Override
    public Socio atualizar(Socio socio) {
        try {
            JsonNode jsonNode = mapper.readTree(file);
            if (jsonNode.isArray()) {
                Iterator<JsonNode> elements = jsonNode.elements();
                while (elements.hasNext()) {
                    JsonNode element = elements.next();
                    if (element.get("numero").asText().equals(socio.getNumero())) {
                        ((ObjectNode) element).put("nome", socio.getNome());
                        ((ObjectNode) element).put("documento", socio.getDocumento());
                    }
                }
            }
            mapper.writeValue(file, jsonNode);
            return socio;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Não foi possível atualizar o objeto no arquivo");
        }
    }

    @Override
    public Optional<Socio> buscarPorDocumento(String documento) {
        try {
            JsonNode jsonNode = mapper.readTree(file);
            if (jsonNode.isArray()) {
                Iterator<JsonNode> elements = jsonNode.elements();
                while (elements.hasNext()) {
                    JsonNode element = elements.next();
                    if (element.get("documento") != null && element.get("documento").asText().equals(documento)) {
                        return Optional.of(mapper.treeToValue(element, Socio.class));
                    }
                }
            }
            return Optional.empty();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Não foi possível ler o arquivo");
        }
    }

    @Override
    public Optional<Socio> buscarPorNumero(String numero) {
        try {
            JsonNode jsonNode = mapper.readTree(file);
            Iterator<JsonNode> elements = jsonNode.elements();
            while (elements.hasNext()) {
                JsonNode element = elements.next();
                if (element.get("numero").asText().equals(numero)) {
                    return Optional.of(mapper.treeToValue(element, Socio.class));
                }
            }

            return Optional.empty();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Não foi possível ler o arquivo");
        }
    }

    @Override
    public ArrayList<Socio> listar(){
        try {
            JsonNode jsonNode = mapper.readTree(file);
            ArrayList<Socio> socios = new ArrayList<>();
            if (jsonNode.isArray()) {
                Iterator<JsonNode> elements = jsonNode.elements();
                while (elements.hasNext()) {
                    JsonNode element = elements.next();
                    socios.add(mapper.treeToValue(element, Socio.class));
                }
            }
            return socios;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Não foi possível ler o arquivo");
        }
    }
}
