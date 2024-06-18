package com.example.camycarrentals.Controller.respuestas.login;

import com.example.camycarrentals.Model.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RespuestaLogin {

    protected String dato;

    public RespuestaLogin(String entrada) {
        dato = entrada;
    }

    public Usuario getLogin() {
        Usuario usuario;
        try {
            ObjectMapper om = new ObjectMapper();
            JsonNode jn = om.readTree(this.dato);
            Integer idUsuario = jn.get("idUsuario").asInt();
            String dniUsuario = jn.get("dniUsuario").asText();
            String nombre = jn.get("nombre").asText();
            String apellido1 = jn.get("apellido1").asText();
            String apellido2 = jn.get("apellido2").asText();
            String correo = jn.get("correo").asText();
            usuario = new Usuario(idUsuario, dniUsuario, nombre, apellido1, apellido2, correo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}
