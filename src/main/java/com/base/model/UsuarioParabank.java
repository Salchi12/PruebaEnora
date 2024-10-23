package com.base.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioParabank {
    private String usuario;
    private String contrasena;

    public UsuarioParabank(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
}
