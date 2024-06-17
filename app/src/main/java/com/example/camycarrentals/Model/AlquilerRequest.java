package com.example.camycarrentals.Model;

import java.util.Objects;

public class AlquilerRequest {

    private Integer idMaquina;

    private Integer idUsuario;

    private String direccion;

    private String fechaInicio;

    private String fechaFin;

    public AlquilerRequest(Integer idMaquina, Integer idUsuario, String direccion, String fechaInicio, String fechaFin) {
        this.idMaquina = idMaquina;
        this.idUsuario = idUsuario;
        this.direccion = direccion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlquilerRequest that = (AlquilerRequest) o;
        return Objects.equals(idMaquina, that.idMaquina) && Objects.equals(idUsuario, that.idUsuario) && Objects.equals(direccion, that.direccion) && Objects.equals(fechaInicio, that.fechaInicio) && Objects.equals(fechaFin, that.fechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMaquina, idUsuario, direccion, fechaInicio, fechaFin);
    }

    @Override
    public String toString() {
        return "AlquilerRequest{" +
                "idMaquina=" + idMaquina +
                ", idUsuario=" + idUsuario +
                ", direccion='" + direccion + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                '}';
    }
}
