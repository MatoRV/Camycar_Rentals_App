package com.example.camycarrentals.Controller.respuestas.login;

import com.example.camycarrentals.Model.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class RespuestaRegistro {

    protected String dato;

    private LinkedHashMap<String, Object> jsonMap;

    private LinkedList<Usuario> mList;

    public RespuestaRegistro(String entrada) {
        dato = entrada;
        jsonMap = new LinkedHashMap<>();
        mList = new LinkedList<>();
    }

    public LinkedList<Usuario> getRegistro() {
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
        mList.add(usuario);
        return mList;
    }
}
