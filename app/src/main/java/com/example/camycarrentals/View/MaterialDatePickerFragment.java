package com.example.camycarrentals.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.app.Dialog;
import android.os.Bundle;
import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.datepicker.MaterialDatePicker;

public class MaterialDatePickerFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("Selecciona un rango de fechas");

        MaterialDatePicker<Pair<Long, Long>> datePicker = builder.build();
        datePicker.addOnPositiveButtonClickListener(selection -> {

            Long startDate = selection.first;
            Long endDate = selection.second;

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String startDateString = sdf.format(new Date(startDate));
            String endDateString = sdf.format(new Date(endDate));

            String selectedDateRange = startDateString + " - " + endDateString;
        });
        datePicker.show();
    }
}
