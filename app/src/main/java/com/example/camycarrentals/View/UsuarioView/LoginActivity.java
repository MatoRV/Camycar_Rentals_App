package com.example.camycarrentals.View.UsuarioView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.camycarrentals.Controller.LoginController;
import com.example.camycarrentals.Model.Usuario;
import com.example.camycarrentals.R;
import com.example.camycarrentals.View.MainActivity;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;

    private TextInputLayout textInputLayoutCorreo, textInputLayoutContrasena;

    private Usuario login;

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
                // TODO QUITAR ESTE IF
                if (correo.equals("admin") && contrasena.equals("1234")) {
                    LoginController.getSingleton().setDatosLogin(new Usuario(1, "11111", "admin", "apellido1", "apellido2", "admin@gmail.com"));
                } else {
                    LoginController.getSingleton().requestLoginFromHttp(correo, contrasena);
                }

                login = LoginController.getSingleton().getDatosLogin();

                if (login != null || (correo.equals("admin") && contrasena.equals("1234"))) {
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
