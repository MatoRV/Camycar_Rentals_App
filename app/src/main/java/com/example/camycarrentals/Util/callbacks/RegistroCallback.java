package com.example.camycarrentals.Util.callbacks;

import com.example.camycarrentals.Model.Usuario;

public interface RegistroCallback {

    void onRegistroSuccess(Usuario usuario);
    void onRegistroFailure(String mensaje);
}
