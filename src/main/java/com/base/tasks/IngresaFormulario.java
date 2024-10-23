package com.base.tasks;

import com.base.model.ClientParabank;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

import static com.base.userInterface.ParabankCreateAccount.*;

public class IngresaFormulario implements Task {
    private final ClientParabank cliente;

    public IngresaFormulario(ClientParabank cliente){
        super();
        this.cliente = cliente;
    }

    public static IngresaFormulario enter(ClientParabank cliente){
        return Tasks.instrumented(IngresaFormulario.class,cliente);
    }

    @Override
    public <T extends Actor> void performAs (T actor){
        actor.attemptsTo(
                Enter.theValue(cliente.getNombre()).into(FIRST_NAME),
                Enter.theValue(cliente.getApellido()).into(LAST_NAME),
                Enter.theValue(cliente.getDireccion()).into(ADDRESS),
                Enter.theValue(cliente.getCiudad()).into(CITY),
                Enter.theValue(cliente.getEstado()).into(STATE),
                Enter.theValue(cliente.getCod_postal()).into(ZIP_CODE),
                Enter.theValue(cliente.getTelefono()).into(PHONE_NUMBER),
                Enter.theValue(cliente.getSsn()).into(SSN),
                Enter.theValue(cliente.getUsuario()).into(USERNAAME),
                Enter.theValue(cliente.getContrasena()).into(PASSWORD),
                Enter.theValue(cliente.getConfirmacion()).into(PASSWORD_CONFIRM)
        );
    }
}
