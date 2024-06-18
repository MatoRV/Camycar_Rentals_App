package com.example.camycarrentals.Controller;

import java.util.List;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.example.camycarrentals.Controller.peticion.alquiler.PeticionAlquiler;
import com.example.camycarrentals.Controller.peticion.localidad.PeticionLocalidades;
import com.example.camycarrentals.Controller.respuestas.alquiler.RespuestaAlquiler;
import com.example.camycarrentals.Controller.respuestas.alquiler.RespuestaLocalidades;
import com.example.camycarrentals.Model.AlquilerResponse;
import com.example.camycarrentals.Util.Conexion;
import com.example.camycarrentals.Util.callbacks.AlquilerCallback;
import com.example.camycarrentals.View.AlquilerView;

public class AlquilerController {

    private static AlquilerController myAlquilerController;

    private static AlquilerView activeActivity;

    private List<CharSequence> localidades;

    private Spinner spinner;

    private Context contextAlquiler;

    private AlquilerResponse alquilerResponse;

    private AlquilerController() {

    }

    public static AlquilerController getSingleton() {
        if (AlquilerController.myAlquilerController == null) {
            myAlquilerController = new AlquilerController();
        }
        return myAlquilerController;
    }

    public Spinner getSpinner() {
        return this.spinner;
    }

    public void setSpinner(Spinner spinner) {
        this.spinner = spinner;
    }

    public Context getContext() {
        return this.contextAlquiler;
    }

    public void setContextAlquiler(Context context) {
        this.contextAlquiler = context;
    }

    public List<CharSequence> getLocalidades() {
        return this.localidades;
    }

    public void setLocalidades(List<CharSequence> localidades) {
        this.localidades = localidades;
    }

    public AlquilerResponse getAlquilerResponse() {
        return alquilerResponse;
    }

    public void setAlquilerResponse(AlquilerResponse alquilerResponse) {
        this.alquilerResponse = alquilerResponse;
    }

    public void requestLocalidadesFromHttp() {
        PeticionLocalidades p = new PeticionLocalidades();
        String enlace = Conexion.URL + "localidades";
        p.requestLocalidades(enlace);
    }

    public void setLocalidadesFromHttp(String json) {
        RespuestaLocalidades r = new RespuestaLocalidades(json);
        localidades = r.getLocalidades();
        setupSpinner(getSpinner(), getContext());
    }

    public void setupSpinner(Spinner spinner, Context context) {
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, getLocalidades());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0,false);
    }

    public String itemSelected(Spinner spinner) {
        final String[] item = new String[1];
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item[0] = spinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return item[0];
    }

    public void requestAlquilerFromHttp(String registroBody, AlquilerCallback alquilerCallback) {
        PeticionAlquiler p = new PeticionAlquiler();
        String enlace = Conexion.URL + "reservas";
        p.requestAlquiler(enlace, registroBody, alquilerCallback);
    }

    public void setAlquilerFromHttp(String json, AlquilerCallback alquilerCallback) {
        RespuestaAlquiler r = new RespuestaAlquiler(json);
        alquilerResponse = r.postAlquiler();
        alquilerCallback.onAlquilerSuccess(alquilerResponse);
    }
}
