package com.example.camycarrentals.Controller;

import java.util.ArrayList;
import java.util.List;
import com.example.camycarrentals.Controller.peticionGET.login.PeticionLogin;
import com.example.camycarrentals.Util.Conexion;
import com.example.camycarrentals.View.LoginActivity;

public class LoginController {

    private static LoginController myLoginController;

    private static LoginActivity activeActivity;

    private List<String> datosLogin;

    private LoginController() {
        datosLogin = new ArrayList<>();
    }

    public static LoginController getSingleton() {
        if (LoginController.myLoginController == null) {
            myLoginController = new LoginController();
        }
        return myLoginController;
    }

    public List<String> getDatosLogin() {
        return this.datosLogin;
    }

    public void requestLoginFromHttp() {
        PeticionLogin p = new PeticionLogin();
        p.requestLogin(Conexion.URL);
    }
}
