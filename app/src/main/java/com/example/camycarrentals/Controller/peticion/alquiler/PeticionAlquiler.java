package com.example.camycarrentals.Controller.peticion.alquiler;

import java.io.IOException;
import androidx.annotation.NonNull;
import com.example.camycarrentals.Controller.AlquilerController;
import com.example.camycarrentals.Util.callbacks.AlquilerCallback;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PeticionAlquiler {

    public PeticionAlquiler() {}

    public void requestAlquiler(String URL, String alquilerBody, AlquilerCallback alquilerCallback) {

        OkHttpClient cliente = new OkHttpClient();

        RequestBody body = RequestBody.create(alquilerBody, MediaType.parse("application/json"));

        Request peticion =
                new Request.Builder().url(URL).post(body).addHeader("Content-Type", "application/json").addHeader("cache-control", "no-cache").build();

        Call llamada = cliente.newCall(peticion);

        llamada.enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String respuesta = response.body().string();
                    AlquilerController.getSingleton().setAlquilerFromHttp(respuesta, alquilerCallback);
                }

            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                alquilerCallback.onAlquilerFailure("No se ha podido hacer la reserva");
            }
        });
    }
}
