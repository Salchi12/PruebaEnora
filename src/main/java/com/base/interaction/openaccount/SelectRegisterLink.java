package com.base.interaction.openaccount;

import com.base.userInterface.ParabankCreateAccount;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SelectRegisterLink implements Task {

    public SelectRegisterLink(){

    }

    public static SelectRegisterLink click(){return new SelectRegisterLink();}

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(ParabankCreateAccount.LINK_REGISTER)
        );
    }
}
