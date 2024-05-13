package com.example.camycarrentals.View;

import android.os.Bundle;
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

        if (getIntent().hasExtra(MainActivity.NEXT_SCREEN)) {
            maquina = (Maquina) getIntent().getSerializableExtra(MainActivity.NEXT_SCREEN);
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
    }
}
