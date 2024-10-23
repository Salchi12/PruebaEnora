package com.base.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import com.base.model.Client;

import static com.base.userInterface.OpenAccountPage.*;


public class IngresarDatosPersonales implements Task {
    private final Client client;
    public IngresarDatosPersonales(Client client){
        super();
        this.client = client;
    }

    public static IngresarDatosPersonales enter(Client client){
        return Tasks.instrumented(IngresarDatosPersonales.class, client);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(client.getDni()).into(CAMPO_DNI),
                Enter.theValue(client.getMail()).into(CAMPO_CORREO),
                Enter.theValue(client.getCelphone()).into(CAMPO_TELEFONO)
        );
        //actor.should(WebElementQuestion);

    }


}
