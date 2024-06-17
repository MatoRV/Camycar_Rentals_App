package com.example.camycarrentals.Model;

public class TipoMaquina {

    private Integer idTipoMaquina;

    private String nombre;

    public TipoMaquina(Integer idTipoMaquina, String nombre) {
        this.idTipoMaquina = idTipoMaquina;
        this.nombre = nombre;
    }

    public TipoMaquina() {

    }

    public Integer getIdTipoMaquina() {
        return idTipoMaquina;
    }

    public void setIdTipoMaquina(Integer idTipoMaquina) {
        this.idTipoMaquina = idTipoMaquina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
