package com.base.model;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class Client {


    private String dni;
    private String mail;
    private String celphone;
    public Client(String dni, String mail, String celphone) {
        this.dni = dni;
        this.mail = mail;
        this.celphone = celphone;
    }

}
