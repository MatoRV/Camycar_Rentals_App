package com.example.camycarrentals.Controller.peticion.login;

import java.io.IOException;
import com.example.camycarrentals.Controller.LoginController;
import com.example.camycarrentals.Util.callbacks.LoginCallback;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

public class PeticionLogin {

    public PeticionLogin() {}

    public void requestLogin(String URL, LoginCallback loginCallback) {
        OkHttpClient cliente = new OkHttpClient();

        Request peticion = new Request.Builder().url(URL).get().addHeader("cache-control", "no-cache").build();

        Call llamada = cliente.newCall(peticion);

        llamada.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                loginCallback.onLoginFailure("No se ha podido loguear");
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String respuesta = response.body().string();
                    LoginController.getSingleton().setLoginFromHttp(respuesta, loginCallback);
                }
            }
        });
    }
}
