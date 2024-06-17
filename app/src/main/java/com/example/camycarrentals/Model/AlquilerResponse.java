package com.example.camycarrentals.Model;

public class AlquilerResponse {

    private Integer idReserva;
    private Maquina maquina;
    private String nombreUsuario;
    private String direccion;

    public AlquilerResponse(Integer idReserva, Maquina maquina, String nombreUsuario, String direccion) {
        this.idReserva = idReserva;
        this.maquina = maquina;
        this.nombreUsuario = nombreUsuario;
        this.direccion = direccion;
    }

    public AlquilerResponse() {

    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
