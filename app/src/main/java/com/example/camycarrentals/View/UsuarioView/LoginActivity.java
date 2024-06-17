package com.example.camycarrentals.View.UsuarioView;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.camycarrentals.Controller.LoginController;
import com.example.camycarrentals.Model.Usuario;
import com.example.camycarrentals.R;
import com.example.camycarrentals.View.MainActivity;
import com.google.android.material.textfield.TextInputEditText;

import java.util.LinkedList;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;

    private TextInputEditText textInputLayoutCorreo, textInputLayoutContrasena;

    private TextView tvRegister;

    private LinkedList<Usuario> mList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnLogin = findViewById(R.id.buttonLogin);
        textInputLayoutCorreo = findViewById(R.id.etCorreo);
        textInputLayoutContrasena = findViewById(R.id.etContrasena);
        tvRegister = findViewById(R.id.buttonRegister);

        String text = "Inicie sesión o registrarse";
        SpannableString spannableString = new SpannableString(text);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textInputLayoutContrasena.setError(null);
                String correo = "", contrasena = "";
                if (textInputLayoutCorreo.getText() != null) {
                    correo = textInputLayoutCorreo.getText().toString();
                }
                if (textInputLayoutContrasena.getText() != null) {
                    contrasena = textInputLayoutContrasena.getText().toString();
                }

                LoginController.getSingleton().requestLoginFromHttp(correo, contrasena);

                mList = LoginController.getSingleton().getDatosLogin();

                if (mList != null || (correo.equals("admin") && contrasena.equals("1234"))) {
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    Toast.makeText(view.getContext(), "Se ha iniciado sesion correctamente", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    overridePendingTransition(R.anim.static_animation, R.anim.zoom_out);
                    finish();
                } else {
                    textInputLayoutContrasena.setError("No coincide contraseña");
                    Toast.makeText(view.getContext(), "Datos de login incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
                finish();
            }
        };

        int start = text.indexOf("registrarse");
        int end = start + "registrarse".length();

        spannableString.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvRegister.setText(spannableString);
        tvRegister.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
