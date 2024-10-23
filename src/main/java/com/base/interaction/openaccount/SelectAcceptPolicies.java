package com.base.interaction.openaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import com.base.userInterface.OpenAccountPage;

public class SelectAcceptPolicies implements Interaction {



    public SelectAcceptPolicies() {

    }

    public static SelectAcceptPolicies click() {
        return new SelectAcceptPolicies();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OpenAccountPage.CHECK_AUTORIZACION)
        );
    }
}
