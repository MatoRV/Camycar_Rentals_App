package com.example.camycarrentals.Controller.respuestas;

import java.util.LinkedList;
import java.util.List;
import com.example.camycarrentals.Model.Maquina;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RespuestaMaquinas {

    protected String datos;

    public RespuestaMaquinas(String entrada) {
        datos = entrada;
    }

    public List<Maquina> getMaquinas() {

        LinkedList<Maquina> dataList = new LinkedList<>();

//        try {
//            ObjectMapper om = new ObjectMapper();
//            JsonNode maquinas = om.readTree(this.datos);
//
//            for (JsonNode maquina: maquinas) {
//                Integer id = maquina.get("idMaquina").asInt();
//                String fabricante = maquina.get("fabricante").asText();
//                String modelo = maquina.get("modelo").asText();
//                Integer capacidadCarga = maquina.get("capacidadCarga").asInt();
//                String estado = maquina.get("estado").asText();
//                String tipoMaquina = maquina.get("tipoMaquina").asText();
//
//                dataList.add(new Maquina(id,fabricante,modelo,capacidadCarga,estado,tipoMaquina));
//            }
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

        JsonElement jsonElement = JsonParser.parseString(this.datos);

        JsonObject json = jsonElement.getAsJsonObject().getAsJsonObject();
        JsonArray jsonLista = json.getAsJsonArray();

        for (int i = 0; i < jsonLista.size(); i++) {
            dataList.add(new Maquina(jsonLista.get(i).getAsJsonArray().get(0).getAsJsonPrimitive().getAsInt(),jsonLista.get(i).getAsJsonArray().get(1).getAsJsonPrimitive().getAsString(),jsonLista.get(i).getAsJsonArray().get(2).getAsJsonPrimitive().getAsString(),
                    jsonLista.get(i).getAsJsonArray().get(3).getAsJsonPrimitive().getAsInt(),jsonLista.get(i).getAsJsonArray().get(4).getAsJsonPrimitive().getAsString(),jsonLista.get(i).getAsJsonArray().get(5).getAsJsonPrimitive().getAsString()));
        }

        return dataList;
    }
}
