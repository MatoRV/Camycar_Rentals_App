package com.example.camycarrentals.Controller;

import com.example.camycarrentals.Controller.peticionGET.login.PeticionLogin;
import com.example.camycarrentals.Controller.respuestas.login.RespuestaLogin;
import com.example.camycarrentals.Util.Conexion;
import com.example.camycarrentals.View.LoginActivity;

public class LoginController {

    private static LoginController myLoginController;

    private static LoginActivity activeActivity;

    private boolean datosLogin;

    private LoginController() {
        
    }

    public static LoginController getSingleton() {
        if (LoginController.myLoginController == null) {
            myLoginController = new LoginController();
        }
        return myLoginController;
    }

    public boolean getDatosLogin() {
        return this.datosLogin;
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
