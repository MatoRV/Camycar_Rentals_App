package com.example.camycarrentals.Controller.peticion.alquiler;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import com.example.camycarrentals.Controller.AlquilerController;
import com.example.camycarrentals.Controller.RegistroController;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PeticionAlquiler {

    public PeticionAlquiler() {}

    public void requestAlquiler(String URL, String alquilerBody) {

        OkHttpClient cliente = new OkHttpClient();

        RequestBody body = RequestBody.create(alquilerBody, MediaType.parse("application/json"));

        Request peticion = new Request.Builder()
                .url(URL)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        Call llamada = cliente.newCall(peticion);

        llamada.enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String respuesta = response.body().string();
                Handler manejador = new Handler(Looper.getMainLooper());
                manejador.post(new Runnable() {
                    @Override
                    public void run() {
                        AlquilerController.getSingleton().setAlquilerFromHttp(respuesta);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                String respuesta = "{\n"
                        + "  \"error\": \"No se ha podido hacer la reserva\"\n"
                        + "}";
                Handler manejador = new Handler(Looper.getMainLooper());
                manejador.post(new Runnable() {
                    @Override
                    public void run() {
                        AlquilerController.getSingleton().setAlquilerFromHttp(respuesta);
                    }
                });
            }
        });
    }
}
