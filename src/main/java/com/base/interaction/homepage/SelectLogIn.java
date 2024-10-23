package com.base.interaction.homepage;

import com.base.userInterface.ParabankLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SelectLogIn implements Task {
    public SelectLogIn(){}

    public static SelectLogIn click(){return new SelectLogIn();}

    @Override
    public <T extends Actor> void performAs (T actor){
        actor.attemptsTo(
                Click.on(ParabankLogin.BUTTON_LOGIN)
        );
    }
}
