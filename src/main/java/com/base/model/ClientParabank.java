package com.base.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientParabank {
    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;
    private String estado;
    private String cod_postal;
    private String telefono;
    private String ssn;
    private String usuario;
    private String contrasena;
    private String confirmacion;

    public ClientParabank(String nombre, String apellido, String direccion, String ciudad, String estado, String cod_postal, String telefono, String ssn, String usuario, String contrasena, String confirmacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.cod_postal = cod_postal;
        this.telefono = telefono;
        this.ssn = ssn;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.confirmacion = confirmacion;
    }
}
