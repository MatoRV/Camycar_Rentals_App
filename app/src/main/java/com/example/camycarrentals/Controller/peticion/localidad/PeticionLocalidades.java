package com.example.camycarrentals.Controller.peticion.localidad;

import java.io.IOException;
import android.os.Handler;
import android.os.Looper;
import com.example.camycarrentals.Controller.AlquilerController;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public class PeticionLocalidades {

    public PeticionLocalidades() {

    }

    public void requestLocalidades(String URL) {
        OkHttpClient cliente = new OkHttpClient();

        Request peticion = new Request.Builder()
                .url(URL)
                .get()
                .addHeader("cache-control", "no-cache")
                .build();

        Call llamada = cliente.newCall(peticion);

        llamada.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                String respuesta = "[\n"
                        + "  {\n"
                        + "    \"localidad\": \"ALHAURIN DE LA TORRE\"\n"
                        + "  },\n"
                        + "  {\n"
                        + "    \"localidad\": \"ALHAURIN EL GRANDE\"\n"
                        + "  },\n"
                        + "  {\n"
                        + "    \"localidad\": \"ALAMEDA\"\n"
                        + "  },\n"
                        + "  {\n"
                        + "    \"localidad\": \"ALFARNATE\"\n"
                        + "  },\n"
                        + "  {\n"
                        + "    \"localidad\": \"ALGARROBO\"\n"
                        + "  },\n"
                        + "  {\n"
                        + "    \"localidad\": \"ALCAUCIN\"\n"
                        + "  }\n]";
                Handler manejador = new Handler(Looper.getMainLooper());
                manejador.post(new Runnable() {
                    @Override
                    public void run() {
                        AlquilerController.getSingleton().setLocalidadesFromHttp(respuesta);
                    }
                });
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String respuesta = response.body().string();
                Handler manejador = new Handler(Looper.getMainLooper());
                manejador.post(new Runnable() {
                    @Override
                    public void run() {
                        AlquilerController.getSingleton().setLocalidadesFromHttp(respuesta);
                    }
                });
            }
        });
    }
}
