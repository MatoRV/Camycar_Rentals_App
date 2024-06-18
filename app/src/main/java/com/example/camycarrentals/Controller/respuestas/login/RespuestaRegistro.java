package com.example.camycarrentals.Controller.respuestas.login;

import java.util.LinkedHashMap;
import com.example.camycarrentals.Model.Usuario;
import org.json.JSONException;
import org.json.JSONObject;

public class RespuestaRegistro {

    protected String dato;

    private LinkedHashMap<String, Object> jsonMap;

    private Usuario usuario;

    public RespuestaRegistro(String entrada) {
        dato = entrada;
        jsonMap = new LinkedHashMap<>();
    }

    public Usuario getRegistro() {
        Usuario usuario;
        try {
            JSONObject jsonObject = new JSONObject(this.dato);
            Integer idUsuario = (Integer) jsonMap.get("idUsuario");
            String dniUsuario = (String) jsonMap.get("dniUsuario");
            String nombre = (String) jsonMap.get("nombre");
            String apellido1 = (String) jsonMap.get("apellido1");
            String apellido2 = (String) jsonMap.get("apellido2");
            String correo = (String) jsonMap.get("correo");
            usuario = new Usuario(idUsuario, dniUsuario, nombre, apellido1, apellido2, correo);
        } catch (JSONException e) {
            usuario = null;
        }

        return usuario;
    }
}
