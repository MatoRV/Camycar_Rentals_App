package com.example.camycarrentals.Controller.peticion.login;

import java.io.IOException;
import androidx.annotation.NonNull;
import com.example.camycarrentals.Controller.RegistroController;
import com.example.camycarrentals.Util.callbacks.RegistroCallback;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PeticionRegistro {

    public PeticionRegistro() {

    }

    public void requestRegistro(String URL, String registroBody, RegistroCallback callback) {

        OkHttpClient cliente = new OkHttpClient();

        RequestBody body = RequestBody.create(registroBody, MediaType.parse("application/json"));

        Request peticion =
                new Request.Builder().url(URL).post(body).addHeader("Content-Type", "application/json").addHeader("cache-control", "no-cache").build();

        Call llamada = cliente.newCall(peticion);

        llamada.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onRegistroFailure("Ha fallado el registro");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String respuesta = response.body().string();
                    RegistroController.getSingleton().setRegistroFromHttp(respuesta, callback);
                }
            }
        });
    }
}
