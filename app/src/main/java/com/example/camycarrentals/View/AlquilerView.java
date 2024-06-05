package com.example.camycarrentals.View;

import static com.example.camycarrentals.View.MainActivity.NEXT_SCREEN;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
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
        final String[] localidad = new String[1];

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

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                localidad[0] = spinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.btnBackAlquiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.btnAlquiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (localidad[0] == null || (fechas[0] == null && fechas[1] == null)) {
                    Toast.makeText(AlquilerView.this, "Faltan por seleccionar datos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AlquilerView.this, fechas.toString() + " " + localidad, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
