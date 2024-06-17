package com.example.camycarrentals.View.UsuarioView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.camycarrentals.Controller.LoginController;
import com.example.camycarrentals.Controller.RegistroController;
import com.example.camycarrentals.Model.Usuario;
import com.example.camycarrentals.R;
import com.example.camycarrentals.View.MainActivity;
import com.example.camycarrentals.databinding.ActivityRegistroBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistroActivity extends AppCompatActivity {

    private ActivityRegistroBinding binding;

    private Usuario login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonRegister.setOnClickListener(v -> {

            String nombre = binding.etNombreUsuario.getText() == null ? "" : binding.etNombreUsuario.getText().toString();
            String primerApellido = binding.etPrimerApellido.getText() == null ? "" : binding.etPrimerApellido.getText().toString();
            String segundoApellido = binding.etSegundoApellido.getText() == null ? "" : binding.etSegundoApellido.getText().toString();
            String correo = binding.etCorreo.getText() == null ? "" : binding.etCorreo.getText().toString();
            String dni = binding.etDni.getText() == null ? "" : binding.etDni.getText().toString();
            String password = binding.etPassword.getText() == null ? "" : binding.etPassword.getText().toString();
            String rePassword = binding.etRePassword.getText() == null ? "" : binding.etRePassword.getText().toString();

            if (validarDatos(nombre, primerApellido, segundoApellido, correo, dni, password, rePassword)) {
                String registroBody = construirJsonBody(nombre, primerApellido, segundoApellido, correo, dni, password);
                RegistroController.getSingleton().requestRegistroFromHttp(registroBody);
            }

            if (RegistroController.getSingleton().getDatosRegistro() != null) {
                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                Toast.makeText(RegistroActivity.this, "Se ha registrado con éxito", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                overridePendingTransition(R.anim.static_animation, R.anim.zoom_out);
                finish();
            }
        });


    }

    private boolean validarDatos(String nombre, String primerApellido, String segundoApellido, String correo, String dni, String password, String rePassword) {
        boolean isValid = true;

        if (TextUtils.isEmpty(nombre)) {
            binding.etNombreUsuario.setError("Este campo es obligatorio");
            isValid = false;
        }

        if (TextUtils.isEmpty(primerApellido)) {
            binding.etPrimerApellido.setError("Este campo es obligatorio");
            isValid = false;
        }

        if (TextUtils.isEmpty(segundoApellido)) {
            binding.etSegundoApellido.setError("Este campo es obligatorio");
            isValid = false;
        }

        if (TextUtils.isEmpty(correo)) {
            binding.etCorreo.setError("Este campo es obligatorio");
            isValid = false;
        }

        if (TextUtils.isEmpty(dni)) {
            binding.etDni.setError("Este campo es obligatorio");
            isValid = false;
        }

        if (TextUtils.isEmpty(password)) {
            binding.etPassword.setError("Este campo es obligatorio");
            isValid = false;
        }

        if (TextUtils.isEmpty(rePassword)) {
            binding.etRePassword.setError("Este campo es obligatorio");
            isValid = false;
        }

        if (!password.equals(rePassword)) {
            binding.etRePassword.setError("Las contraseñas no coinciden");
            isValid = false;
        }

        return isValid;
    }

    private String construirJsonBody(String nombre, String primerApellido, String segundoApellido, String correo, String dni, String password) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nombre", nombre);
            jsonObject.put("apellido1", primerApellido);
            jsonObject.put("apellido2", segundoApellido);
            jsonObject.put("correo", correo);
            jsonObject.put("contrasena", password);
            jsonObject.put("dniUsuario", dni);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}