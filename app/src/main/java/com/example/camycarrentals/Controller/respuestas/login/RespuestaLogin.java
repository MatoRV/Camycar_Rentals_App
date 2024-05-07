package com.example.camycarrentals.Controller.respuestas.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RespuestaLogin {

    protected String dato;

    public RespuestaLogin(String entrada) {
        dato = entrada;
    }

    public boolean getLogin() {
        boolean existe;
        try {
            ObjectMapper om = new ObjectMapper();
            JsonNode jn = om.readTree(this.dato);

            existe = jn.get("existe").asBoolean();
            System.out.println("El valor de 'existe' es: " + existe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return existe;
    }
}
