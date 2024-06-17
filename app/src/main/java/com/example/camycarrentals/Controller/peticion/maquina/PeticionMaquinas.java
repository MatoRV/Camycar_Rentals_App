package com.example.camycarrentals.Controller.peticion.maquina;

import java.io.IOException;
import android.os.Handler;
import android.os.Looper;
import com.example.camycarrentals.Controller.MainController;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PeticionMaquinas {

    public PeticionMaquinas() {

    }

    public void requestMaquinas(String URL) {
        OkHttpClient cliente = new OkHttpClient();

        Request peticion = new Request.Builder().url(URL + "maquinas").get().addHeader("cache-control", "no-cache").build();

        Call llamada = cliente.newCall(peticion);
        llamada.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String respuesta = "[\n"
                        + "  {\n"
                        + "    \"capacidadCarga\": 4000,\n"
                        + "    \"diasReservados\": {\n"
                        + "      \"dias\": [\n"
                        + "        \"2024-06-04\",\n"
                        + "        \"2024-06-05\",\n"
                        + "        \"2024-06-06\",\n"
                        + "        \"2024-06-07\"\n"
                        + "      ]\n"
                        + "    },\n"
                        + "    \"estado\": \"ALQUILADO\",\n"
                        + "    \"fabricante\": \"HANGCHA\",\n"
                        + "    \"idMaquina\": 1,\n"
                        + "    \"modelo\": \"XF A25\",\n"
                        + "    \"peso\": 3000,\n"
                        + "    \"tipoMaquina\": {\n"
                        + "      \"nombre\": \"Torito\"\n"
                        + "    }\n"
                        + "  },\n"
                        + "  {\n"
                        + "    \"capacidadCarga\": 2000,\n"
                        + "    \"diasReservados\": {\n"
                        + "      \"dias\": []\n"
                        + "    },\n"
                        + "    \"estado\": \"DISPONIBLE\",\n"
                        + "    \"fabricante\": \"LIFTER\",\n"
                        + "    \"idMaquina\": 2,\n"
                        + "    \"modelo\": \"LX 12\",\n"
                        + "    \"peso\": 500,\n"
                        + "    \"tipoMaquina\": {\n"
                        + "      \"nombre\": \"Carretilla\"\n"
                        + "    }\n"
                        + "  },\n"
                        + "  {\n"
                        + "    \"capacidadCarga\": 4000,\n"
                        + "    \"diasReservados\": {\n"
                        + "      \"dias\": []\n"
                        + "    },\n"
                        + "    \"estado\": \"DISPONIBLE\",\n"
                        + "    \"fabricante\": \"Mitsubishi\",\n"
                        + "    \"idMaquina\": 3,\n"
                        + "    \"modelo\": \"MT GX 2134\",\n"
                        + "    \"peso\": 3200,\n"
                        + "    \"tipoMaquina\": {\n"
                        + "      \"nombre\": \"Torito\"\n"
                        + "    }\n"
                        + "  }\n"
                        + "]";
                Handler manejador = new Handler(Looper.getMainLooper());

                manejador.post(new Runnable() {
                    @Override
                    public void run() {
                        MainController.getSingleton().setMaquinasFromHttp(respuesta);
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String respuesta = response.body().string();
                Handler manejador = new Handler(Looper.getMainLooper());
                manejador.post(new Runnable() {
                    @Override
                    public void run() {
                        MainController.getSingleton().setMaquinasFromHttp(respuesta);
                    }
                });
            }
        });
    }
}
