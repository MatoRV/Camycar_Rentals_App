package com.example.camycarrentals.Util.callbacks;

import com.example.camycarrentals.Model.AlquilerResponse;

public interface AlquilerCallback {

    void onAlquilerSuccess(AlquilerResponse alquilerResponse);
    void onAlquilerFailure(String mensaje);
}
