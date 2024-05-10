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
            binding.putModeloMaquina.setText(maquina.getModelo());
        }
    }
}
