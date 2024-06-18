package com.example.camycarrentals.View.UsuarioView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.camycarrentals.Controller.LoginController;
import com.example.camycarrentals.R;
import com.google.android.material.button.MaterialButton;

public class InformacionPersonalView extends AppCompatActivity {

    private TextView tvNombre, tvCorreo, tvApellidos, tvContrasena, tvDni;

    private MaterialButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion_personal);

        tvNombre = findViewById(R.id.tvNombreIP);
        tvCorreo = findViewById(R.id.tvCorreoIP);
        tvApellidos = findViewById(R.id.tvApellidosIP);
        tvContrasena = findViewById(R.id.tvContrasenaIP);
        tvDni = findViewById(R.id.tvDniIP);
        btnBack = findViewById(R.id.btnBackPI);

        tvNombre.setText(LoginController.getSingleton().getDatosLogin().getNombre());
        tvCorreo.setText(LoginController.getSingleton().getDatosLogin().getCorreo());
        tvDni.setText(LoginController.getSingleton().getDatosLogin().getDniUsuario());
        String apellidos = LoginController.getSingleton().getDatosLogin().getApellido1() + " " + LoginController.getSingleton().getDatosLogin().getApellido2();
        tvApellidos.setText(apellidos);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
