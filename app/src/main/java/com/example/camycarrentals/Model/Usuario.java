package com.example.camycarrentals.Model;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {

    private Integer idUsuario;

    private String dniUsuario;

    private String nombre;

    private String apellido1;

    private String apellido2;

    private String correo;

    public Usuario() {
    }
    public Usuario(Integer idUsuario, String dniUsuario, String nombre, String apellido1, String apellido2, String correo) {
        this.idUsuario = idUsuario;
        this.dniUsuario = dniUsuario;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getDniUsuario() {
        return dniUsuario;
    }
    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario)
                && Objects.equals(dniUsuario, usuario.dniUsuario)
                && Objects.equals(nombre, usuario.nombre)
                && Objects.equals(apellido1, usuario.apellido1)
                && Objects.equals(apellido2, usuario.apellido2)
                && Objects.equals(correo, usuario.correo);
    }
    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, dniUsuario, nombre, apellido1, apellido2, correo);
    }

    @Override
    public String toString() {
        return "Usuario{"
                + "idUsuario="
                + idUsuario
                + ", dniUsuario='"
                + dniUsuario
                + '\''
                + ", nombre='"
                + nombre
                + '\''
                + ", apellido1='"
                + apellido1
                + '\''
                + ", apellido2='"
                + apellido2
                + '\''
                + ", correo='"
                + correo
                + '\''
                + '}';
    }
}
