package com.example.camycarrentals.Controller.respuestas.alquiler;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RespuestaLocalidades {

    protected String datos;

    public RespuestaLocalidades(String entrada) {
        datos = entrada;
    }

    public List<CharSequence> getLocalidades() {

        List<CharSequence> localidades = new ArrayList<>();

        try {
            ObjectMapper om = new ObjectMapper();
            JsonNode jn = om.readTree(this.datos);

            for (JsonNode localidad: jn) {
                localidades.add(localidad.get("localidad").asText());
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return localidades;
    }
}
