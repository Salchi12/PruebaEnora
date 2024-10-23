package com.base.interaction.homepage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import com.base.userInterface.HomePage;

public class SelectOpenAccount implements Task {



    public SelectOpenAccount() {

    }

    public static SelectOpenAccount click() {
        return new SelectOpenAccount();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.BOTON_ABRIR_CUENTA)
        );
    }
}
