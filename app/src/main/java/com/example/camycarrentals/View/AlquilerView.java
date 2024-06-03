package com.example.camycarrentals.View;

import static com.example.camycarrentals.View.MainActivity.NEXT_SCREEN;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.example.camycarrentals.Controller.AlquilerController;
import com.example.camycarrentals.Model.Maquina;
import com.example.camycarrentals.R;
import com.example.camycarrentals.databinding.AlquilerViewBinding;

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

        binding.tietDatePickerAlquiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tietDatePickerAlquiler:
                        showDatePickerDialog();
                        break;
                }
            }
        });
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = new DatePickerFragment().newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String fechaSeleccionada = dosDigitos(day) + " / " + dosDigitos(month + 1) + " / " + year;
                binding.tietDatePickerAlquiler.setText(fechaSeleccionada);
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private String dosDigitos(int n) {
        return (n >= 9) ? ("0" + n) : String.valueOf(n);
    }
}
