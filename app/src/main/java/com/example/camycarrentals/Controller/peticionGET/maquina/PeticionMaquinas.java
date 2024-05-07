package com.example.camycarrentals.Controller.peticionGET.maquina;

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

        Request peticion = new Request.Builder()
                .url(URL + "maquinas")
                .get()
                .addHeader("cache-control", "no-cache")
                .build();

        Call llamada = cliente.newCall(peticion);
        llamada.enqueue(new Callback() {
            @Override
            public void onFailure( Call call, IOException e) {
                String respuesta = "[{\"capacidadCarga\":2500,\"estado\":\"DISPONIBLE\",\"fabricante\":\"F1\",\"idMaquina\":1,\"modelo\":\"M2\","
                        + "\"tipoMaquina\":\"Torito\"},{\"capacidadCarga\":1500,\"estado\":\"DISPONIBLE\",\"fabricante\":\"F1\",\"idMaquina\":2,"
                        + "\"modelo\":\"M3\",\"tipoMaquina\":\"Carretilla\"},{\"capacidadCarga\":1000,\"estado\":\"DISPONIBLE\",\"fabricante\":\"F2\","
                        + "\"idMaquina\":3,\"modelo\":\"M1\",\"tipoMaquina\":\"Elevadora\"},{\"capacidadCarga\":2000,\"estado\":\"DISPONIBLE\","
                        + "\"fabricante\":\"F1\",\"idMaquina\":4,\"modelo\":\"M1\",\"tipoMaquina\":\"Torito\"}]";
                Handler manejador = new Handler(Looper.getMainLooper());

                manejador.post(new Runnable() {
                    @Override
                    public void run() {
                        MainController.getSingleton().setMaquinasFromHttp(respuesta);
                    }
                });
            }
            @Override
            public void onResponse(Call call,Response response) throws IOException {
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
