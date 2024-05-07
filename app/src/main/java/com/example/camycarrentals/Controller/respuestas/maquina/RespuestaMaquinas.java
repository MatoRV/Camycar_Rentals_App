package com.example.camycarrentals.Controller.respuestas.maquina;

import java.util.ArrayList;
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
                String tipoMaquina = maquina.get("tipoMaquina").asText();

                dataList.add(new Maquina(id,fabricante,modelo,capacidadCarga,estado,tipoMaquina));
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return dataList;
    }
}
