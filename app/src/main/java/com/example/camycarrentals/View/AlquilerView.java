package com.example.camycarrentals.View;

import static com.example.camycarrentals.View.MainActivity.NEXT_SCREEN;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import com.example.camycarrentals.Controller.AlquilerController;
import com.example.camycarrentals.Model.Maquina;
import com.example.camycarrentals.databinding.AlquilerViewBinding;
import com.google.android.material.datepicker.MaterialDatePicker;

public class AlquilerView extends AppCompatActivity {

    private AlquilerViewBinding binding;

    private Spinner spinner;

    private Maquina maquina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AlquilerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent().hasExtra(NEXT_SCREEN)) {
            maquina = (Maquina) getIntent().getSerializableExtra(NEXT_SCREEN);
        }

        spinner = binding.spinnerLocalidadAlquiler;

        String nombreMaquina = maquina.getFabricante() + " " + maquina.getModelo();
        binding.tvNombreMaquina.setText(nombreMaquina);

        AlquilerController.getSingleton().requestLocalidadesFromHttp();

        AlquilerController.getSingleton().setSpinner(spinner);
        AlquilerController.getSingleton().setContextAlquiler(AlquilerView.this);

        String[] fechas = new String[2];

        MaterialDatePicker<Pair<Long, Long>> materialDatePicker = MaterialDatePickerFragment.crearDatePicker();
        binding.tietDatePickerAlquiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(selection -> {

            Long startDate = selection.first;
            Long endDate = selection.second;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
            fechas[0] = sdf.format(new Date(startDate));
            fechas[1] = sdf.format(new Date(endDate));

            String selectedDates = fechas[0] + " - " + fechas[1];

            binding.tietDatePickerAlquiler.setText(selectedDates);
        });
    }

}
