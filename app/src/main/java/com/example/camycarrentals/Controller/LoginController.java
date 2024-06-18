package com.example.camycarrentals.Controller;

import com.example.camycarrentals.Controller.peticion.login.PeticionLogin;
import com.example.camycarrentals.Controller.respuestas.login.RespuestaLogin;
import com.example.camycarrentals.Model.Usuario;
import com.example.camycarrentals.Util.Conexion;
import com.example.camycarrentals.Util.callbacks.LoginCallback;
import com.example.camycarrentals.View.UsuarioView.LoginActivity;

public class LoginController {

    private static LoginController myLoginController;

    private static LoginActivity activeActivity;

    private Usuario datosLogin;

    private LoginController() {
        
    }

    public static LoginController getSingleton() {
        if (LoginController.myLoginController == null) {
            myLoginController = new LoginController();
        }
        return myLoginController;
    }

    public Usuario getDatosLogin() {
        return this.datosLogin;
    }

    public void setDatosLogin(Usuario datosLogin) {
        this.datosLogin = datosLogin;
    }

    public void requestLoginFromHttp(String correo, String contrasena, LoginCallback loginCallback) {
        PeticionLogin p = new PeticionLogin();
        String enlace = Conexion.URL + "usuarios/comprobar?correo=" + correo + "&contrasena=" + contrasena;
        p.requestLogin(enlace, loginCallback);
    }

    public void setLoginFromHttp(String json, LoginCallback loginCallback) {
        RespuestaLogin r = new RespuestaLogin(json);
        datosLogin = r.getLogin();
        loginCallback.onLoginSuccess(datosLogin);
    }


}
