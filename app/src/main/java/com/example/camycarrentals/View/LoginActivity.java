package com.example.camycarrentals.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
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
                if (textInputLayoutCorreo.getEditText() != null) {
                    String correo = textInputLayoutCorreo.getEditText().getText().toString();
                }
                if (textInputLayoutContrasena.getEditText() != null) {
                    String contrasena = textInputLayoutContrasena.getEditText().getText().toString();
                }

                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
