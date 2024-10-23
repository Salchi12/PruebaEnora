package com.base.interaction.openaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import com.base.userInterface.OpenAccountPage;

public class SelectGoNext implements Interaction {



    public SelectGoNext() {

    }

    public static SelectGoNext click() {
        return new SelectGoNext();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OpenAccountPage.BOTON_SIGUIENTE_ABRIR_CUENTA)
        );
    }
}
