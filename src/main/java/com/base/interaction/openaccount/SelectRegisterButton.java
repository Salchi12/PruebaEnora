package com.base.interaction.openaccount;

import com.base.userInterface.ParabankCreateAccount;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SelectRegisterButton implements Task {

    public SelectRegisterButton(){

    }

    public static SelectRegisterButton click(){return new SelectRegisterButton();}

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ParabankCreateAccount.BUTTON_REGISTER)
        );
    }
}
