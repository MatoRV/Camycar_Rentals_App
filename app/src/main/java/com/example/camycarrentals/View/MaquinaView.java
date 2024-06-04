package com.example.camycarrentals.View;

import static com.example.camycarrentals.View.MainActivity.NEXT_SCREEN;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.camycarrentals.Model.Maquina;
import com.example.camycarrentals.databinding.MaquinaBinding;

public class MaquinaView extends AppCompatActivity {

    private MaquinaBinding binding;

    private Maquina maquina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MaquinaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent().hasExtra(NEXT_SCREEN)) {
            maquina = (Maquina) getIntent().getSerializableExtra(NEXT_SCREEN);
        }
        if (maquina != null) {
            binding.tvModeloMaquina.setText(maquina.getFabricante());
            binding.putModeloMaquina.setText(maquina.getModelo());
            binding.tvTipoMaquina.setText(maquina.getTipoMaquina());
            String capacidadCarga = maquina.getCapacidadCarga() + "KG";
            binding.tvCapacidadCarga.setText(capacidadCarga);
            String peso = maquina.getPeso() + "KG";
            binding.tvPeso.setText(peso);
        }
        if (maquina != null) {
            binding.btnAlquiler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MaquinaView.this, AlquilerView.class);
                    intent.putExtra(NEXT_SCREEN, maquina);
                    startActivity(intent);
                }
            });
        }

        binding.btnBackMaquina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
