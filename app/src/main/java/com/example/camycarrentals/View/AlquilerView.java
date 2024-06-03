package com.example.camycarrentals.View;

import android.os.Bundle;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.example.camycarrentals.Controller.AlquilerController;
import com.example.camycarrentals.databinding.AlquilerViewBinding;

public class AlquilerView extends AppCompatActivity {

    private AlquilerViewBinding binding;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AlquilerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spinner = binding.spinnerLocalidadAlquiler;

        AlquilerController.getSingleton().requestLocalidadesFromHttp();

        AlquilerController.getSingleton().setupSpinner(spinner, AlquilerView.this);
        
    }
}
