package com.example.camycarrentals.Util.callbacks;

import com.example.camycarrentals.Model.Usuario;

public interface LoginCallback {

    void onLoginSuccess(Usuario usuario);
    void onLoginFailure(String mensaje);
}
