package com.example.camycarrentals.Model;

import java.util.Objects;

public class Maquina {

    private Integer idMaquina;

    private String fabricante;

    private String modelo;

    private Integer capacidadCarga;

    private String estado;

    private String tipoMaquina;

    public Maquina(Integer idMaquina, String fabricante, String modelo, Integer capacidadCarga, String estado, String tipoMaquina) {
        this.idMaquina = idMaquina;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.capacidadCarga = capacidadCarga;
        this.estado = estado;
        this.tipoMaquina = tipoMaquina;
    }

    public Maquina() {
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }
    public String getFabricante() {
        return fabricante;
    }
    public String getModelo() {
        return modelo;
    }
    public Integer getCapacidadCarga() {
        return capacidadCarga;
    }
    public String getEstado() {
        return estado;
    }
    public String getTipoMaquina() {
        return tipoMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setCapacidadCarga(Integer capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setTipoMaquina(String tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Maquina maquina = (Maquina) o;
        return Objects.equals(idMaquina, maquina.idMaquina)
                && Objects.equals(fabricante, maquina.fabricante)
                && Objects.equals(modelo, maquina.modelo)
                && Objects.equals(capacidadCarga, maquina.capacidadCarga)
                && Objects.equals(estado, maquina.estado)
                && Objects.equals(tipoMaquina, maquina.tipoMaquina);
    }
    @Override
    public int hashCode() {
        return Objects.hash(idMaquina, fabricante, modelo, capacidadCarga, estado, tipoMaquina);
    }

    @Override
    public String toString() {
        return "Maquina{"
                + "idMaquina="
                + idMaquina
                + ", fabricante='"
                + fabricante
                + '\''
                + ", modelo='"
                + modelo
                + '\''
                + ", capacidadCarga="
                + capacidadCarga
                + ", estado='"
                + estado
                + '\''
                + ", tipoMaquina='"
                + tipoMaquina
                + '\''
                + '}';
    }
}
