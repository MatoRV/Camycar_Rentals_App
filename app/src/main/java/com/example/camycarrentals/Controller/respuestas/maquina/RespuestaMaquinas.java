package com.example.camycarrentals.Controller.respuestas.maquina;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.util.Log;
import com.example.camycarrentals.Model.Maquina;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class RespuestaMaquinas {

    protected String datos;

    public RespuestaMaquinas(String entrada) {
        datos = entrada;
    }

    public ArrayList<Maquina> getMaquinas() {

        ArrayList<Maquina> dataList = new ArrayList<>();

        ObjectMapper om = new ObjectMapper();
        ObjectReader or = om.reader();

        try {

            JsonNode maquinas = or.readTree(this.datos);

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
                List<String> dias = new ArrayList<>();

                if (diasReservados != null && diasReservados.has("dias")) {
                    JsonNode arrayDias = diasReservados.get("dias");
                    for (JsonNode dia : arrayDias) {
                        dias.add(dia.asText());
                    }
                }

                Log.d("FECHAS", dias.toString());
                dataList.add(new Maquina(id, fabricante, modelo, capacidadCarga, estado, tipoMaquina, peso, dias));
            }
        } catch (JsonProcessingException e) {
            Log.d("RespuestaMaquinas", "Error procesando json", e);
            throw new RuntimeException("Error procesando JSON", e);
        }

        return dataList;
    }
}
