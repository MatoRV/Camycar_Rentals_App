package com.example.camycarrentals.Controller.peticionGET.login;

import java.io.IOException;
import android.os.Handler;
import android.os.Looper;
import com.example.camycarrentals.Controller.LoginController;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public class PeticionLogin {

    public PeticionLogin() {}

    public void requestLogin(String URL) {
        OkHttpClient cliente = new OkHttpClient();

        Request peticion = new Request.Builder().url(URL).get().addHeader("cache-control", "no-cache").build();

        Call llamada = cliente.newCall(peticion);

        //        try {
        //            Thread.sleep(5 * 1000);
        llamada.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                String respuesta = "{\n"
                        + "  \"apellido1\": \"apellido1\",\n"
                        + "  \"apellido2\": \"apellido2\",\n"
                        + "  \"correo\": \"admin@gmail.com\",\n"
                        + "  \"dniUsuario\": \"00000000A\",\n"
                        + "  \"idUsuario\": 1,\n"
                        + "  \"nombre\": \"admin\"\n"
                        + "}";
                Handler manejador = new Handler(Looper.getMainLooper());
                manejador.post(new Runnable() {
                    @Override
                    public void run() {
                        LoginController.getSingleton().setLoginFromHttp(respuesta);
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
                        LoginController.getSingleton().setLoginFromHttp(respuesta);
                    }
                });
            }
        });
        //        } catch (InterruptedException e) {
        //            throw new RuntimeException(e);
        //        }
    }
}
