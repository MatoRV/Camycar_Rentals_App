package com.example.camycarrentals.Controller;

import com.example.camycarrentals.Controller.peticion.login.PeticionRegistro;
import com.example.camycarrentals.Controller.respuestas.login.RespuestaRegistro;
import com.example.camycarrentals.Model.Usuario;
import com.example.camycarrentals.Util.Conexion;
import com.example.camycarrentals.Util.callbacks.RegistroCallback;
import com.example.camycarrentals.View.UsuarioView.RegistroActivity;

public class RegistroController {

    private static RegistroController registroController;

    private static RegistroActivity activeActivity;

    private Usuario datosRegistro;

    private RegistroController() {

    }

    public static RegistroController getSingleton() {
        if (RegistroController.registroController == null) {
            registroController = new RegistroController();
        }
        return registroController;
    }

    public Usuario getDatosRegistro() {
        return this.datosRegistro;
    }

    public void requestRegistroFromHttp(String registroBody, RegistroCallback registroCallback) {
        PeticionRegistro p = new PeticionRegistro();
        String enlace = Conexion.URL + "usuarios";
        p.requestRegistro(enlace, registroBody, registroCallback);
    }

    public void setRegistroFromHttp(String json, RegistroCallback registroCallback) {
        RespuestaRegistro r = new RespuestaRegistro(json);
        datosRegistro = r.getRegistro();
        registroCallback.onRegistroSuccess(datosRegistro);
    }
}
