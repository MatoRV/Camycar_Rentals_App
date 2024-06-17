package com.example.camycarrentals.Controller;

import com.example.camycarrentals.Controller.peticionGET.login.PeticionLogin;
import com.example.camycarrentals.Controller.peticionGET.login.PeticionRegistro;
import com.example.camycarrentals.Controller.respuestas.login.RespuestaLogin;
import com.example.camycarrentals.Model.Usuario;
import com.example.camycarrentals.Util.Conexion;
import com.example.camycarrentals.View.UsuarioView.LoginActivity;
import com.google.gson.Gson;

import java.util.LinkedList;

public class LoginController {

    private static LoginController myLoginController;

    private static LoginActivity activeActivity;

    private LinkedList<Usuario> datosLogin;

    private LoginController() {
        
    }

    public static LoginController getSingleton() {
        if (LoginController.myLoginController == null) {
            myLoginController = new LoginController();
        }
        return myLoginController;
    }

    public LinkedList<Usuario> getDatosLogin() {
        return this.datosLogin;
    }

    public void setDatosLogin(LinkedList<Usuario> datosLogin) {
        this.datosLogin = datosLogin;
    }

    public void requestLoginFromHttp(String correo, String contrasena) {
        PeticionLogin p = new PeticionLogin();
        String enlace = Conexion.URL + "usuarios/comprobar?correo=" + correo + "&contrasena=" + contrasena;
        p.requestLogin(enlace);
    }

    public void setLoginFromHttp(String json) {
        RespuestaLogin r = new RespuestaLogin(json);
        datosLogin = r.getLogin();
    }


}
