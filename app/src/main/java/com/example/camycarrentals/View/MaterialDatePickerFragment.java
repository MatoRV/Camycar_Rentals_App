package com.example.camycarrentals.View;

import androidx.core.util.Pair;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;

public class MaterialDatePickerFragment {

    public static MaterialDatePicker<Pair<Long, Long>> crearDatePicker() {
        CalendarConstraints.Builder calendarBuilder = new CalendarConstraints.Builder();

        // Bloquea las fechas antes de hoy
        calendarBuilder.setValidator(DateValidatorPointForward.now());

        MaterialDatePicker.Builder<Pair<Long, Long>> materarialDatePickerBuilder = MaterialDatePicker.Builder.dateRangePicker();
        materarialDatePickerBuilder.setTitleText("Seleccione un rango de fechas");
        materarialDatePickerBuilder.setCalendarConstraints(calendarBuilder.build());

        return materarialDatePickerBuilder.build();
    }
}
