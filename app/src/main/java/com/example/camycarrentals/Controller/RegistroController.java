package com.example.camycarrentals.Controller;

import com.example.camycarrentals.Controller.peticion.login.PeticionRegistro;
import com.example.camycarrentals.Controller.respuestas.login.RespuestaRegistro;
import com.example.camycarrentals.Model.Usuario;
import com.example.camycarrentals.Util.Conexion;
import com.example.camycarrentals.View.UsuarioView.RegistroActivity;

import java.util.LinkedList;

public class RegistroController {

    private static RegistroController registroController;

    private static RegistroActivity activeActivity;

    private LinkedList<Usuario> datosRegistro;

    private RegistroController() {

    }

    public static RegistroController getSingleton() {
        if (RegistroController.registroController == null) {
            registroController = new RegistroController();
        }
        return registroController;
    }

    public LinkedList<Usuario> getDatosRegistro() {
        return this.datosRegistro;
    }

    public void requestRegistroFromHttp(String registroBody) {
        PeticionRegistro p = new PeticionRegistro();
        String enlace = Conexion.URL + "usuarios";;
        p.requestRegistro(enlace, registroBody);
    }

    public void setRegistroFromHttp(String json) {
        RespuestaRegistro r = new RespuestaRegistro(json);
        datosRegistro = r.getRegistro();
    }
}
