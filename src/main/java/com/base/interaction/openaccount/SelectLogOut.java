package com.base.interaction.openaccount;

import com.base.userInterface.ParabankCreateAccount;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SelectLogOut implements Task {

    public SelectLogOut(){}

    public static SelectLogOut click(){return new SelectLogOut();}

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(ParabankCreateAccount.LINK_LOGOUT)
        );
    }
}
