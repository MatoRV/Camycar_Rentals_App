package com.example.camycarrentals.Controller.respuestas.maquina;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.util.Log;
import com.example.camycarrentals.Model.Maquina;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RespuestaMaquinas {

    protected String datos;

    public RespuestaMaquinas(String entrada) {
        datos = entrada;
    }

    public ArrayList<Maquina> getMaquinas() {

        ArrayList<Maquina> dataList = new ArrayList<>();

        try {
            ObjectMapper om = new ObjectMapper();
            JsonNode maquinas = om.readTree(this.datos);

            for (JsonNode maquina: maquinas) {
                Integer id = maquina.get("idMaquina").asInt();
                String fabricante = maquina.get("fabricante").asText();
                String modelo = maquina.get("modelo").asText();
                Integer capacidadCarga = maquina.get("capacidadCarga").asInt();
                String estado = maquina.get("estado").asText();
                JsonNode tipoMaquinaNombre = maquina.get("tipoMaquina");
                String tipoMaquina = tipoMaquinaNombre.get("nombre").asText();
                Integer peso = maquina.get("peso").asInt();
                JsonNode diasReservados = maquina.get("diasReservados");
                JsonNode arrayDias = diasReservados.get("dias");
                List<String> dias = new ArrayList<>();
                if (arrayDias.size() != 0) {
                    for (int i = 0; i < arrayDias.size(); i++) {
                        dias.add(arrayDias.get(i).asText());
                    }
                } else {
                    dias = Collections.emptyList();
                }
                Log.d("FECHAS", dias.toString());
                dataList.add(new Maquina(id, fabricante, modelo, capacidadCarga, estado, tipoMaquina, peso, dias));
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return dataList;
    }
}
