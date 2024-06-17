package com.example.camycarrentals.Controller.respuestas.alquiler;

import com.example.camycarrentals.Model.AlquilerResponse;
import com.example.camycarrentals.Model.Maquina;
import com.example.camycarrentals.Model.TipoMaquina;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedList;
import java.util.List;

public class RespuestaAlquiler {

    protected String datos;

    private LinkedList<AlquilerResponse> mList;

    public RespuestaAlquiler(String entrada) {
        datos = entrada;
        mList = new LinkedList<>();
    }

    public LinkedList<AlquilerResponse> postAlquiler() {

        AlquilerResponse alquilerResponse;

        try {
            ObjectMapper om = new ObjectMapper();
            JsonNode jn = om.readTree(this.datos);

            Integer idReserva = jn.get("idReserva").asInt();
            String nombreUsuario = jn.get("nombreUsuario").asText();
            String direccion = jn.get("direccion").asText();

            JsonNode maquinaNode = jn.get("maquina");
            Integer idMaquina = maquinaNode.get("idMaquina").asInt();
            String fabricante = maquinaNode.get("fabricante").asText();
            String modelo = maquinaNode.get("modelo").asText();
            Integer capacidadCarga = maquinaNode.get("capacidadCarga").asInt();
            String estado = maquinaNode.get("estado").asText();
            Integer peso = maquinaNode.get("peso").asInt();

            JsonNode tipoMaquinaNode = maquinaNode.get("tipoMaquina");
            String nombreTipoMaquina = tipoMaquinaNode.get("nombre").asText();
            TipoMaquina tipoMaquina = new TipoMaquina();
            tipoMaquina.setNombre(nombreTipoMaquina);

            JsonNode diasReservadosNode = maquinaNode.get("diasReservados");
            List<String> dias = new LinkedList<>();
            for (JsonNode diaNode : diasReservadosNode.get("dias")) {
                dias.add(diaNode.asText());
            }

            Maquina maquina = new Maquina();
            maquina.setIdMaquina(idMaquina);
            maquina.setFabricante(fabricante);
            maquina.setModelo(modelo);
            maquina.setCapacidadCarga(capacidadCarga);
            maquina.setEstado(estado);
            maquina.setPeso(peso);
            maquina.setTipoMaquina(tipoMaquina.getNombre());
            maquina.setDias(dias);

            alquilerResponse = new AlquilerResponse();
            alquilerResponse.setIdReserva(idReserva);
            alquilerResponse.setMaquina(maquina);
            alquilerResponse.setNombreUsuario(nombreUsuario);
            alquilerResponse.setDireccion(direccion);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        mList.add(alquilerResponse);

        return mList;
    }
}
