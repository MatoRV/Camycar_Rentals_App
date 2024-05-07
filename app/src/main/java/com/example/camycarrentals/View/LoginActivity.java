package com.example.camycarrentals.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.camycarrentals.Controller.LoginController;
import com.example.camycarrentals.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;

    private TextInputLayout textInputLayoutCorreo, textInputLayoutContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnLogin = findViewById(R.id.buttonLogin);
        textInputLayoutCorreo = findViewById(R.id.editTextCorreo);
        textInputLayoutContrasena = findViewById(R.id.editTextContrasena);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textInputLayoutContrasena.setError(null);
                String correo = "", contrasena = "";
                if (textInputLayoutCorreo.getEditText() != null) {
                    correo = textInputLayoutCorreo.getEditText().getText().toString();
                }
                if (textInputLayoutContrasena.getEditText() != null) {
                    contrasena = textInputLayoutContrasena.getEditText().getText().toString();
                }
                LoginController.getSingleton().requestLoginFromHttp(correo, contrasena);
                boolean login;
                //                try {
                //                    Thread.sleep(4 * 1000);
                login = LoginController.getSingleton().getDatosLogin();
                //                } catch (InterruptedException e) {
                //                    throw new RuntimeException(e);
                //                }
                if (login) {
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    Toast.makeText(view.getContext(), "Se ha iniciado sesion correctamente", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    textInputLayoutContrasena.setError("No coincide contraseña");
                    Toast.makeText(view.getContext(), "Datos de login incorrectos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
