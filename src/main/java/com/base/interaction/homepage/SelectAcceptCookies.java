package com.base.interaction.homepage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import com.base.userInterface.HomePage;

public class SelectAcceptCookies implements Task {



    public SelectAcceptCookies() {

    }

    public static SelectAcceptCookies click() {
        return new SelectAcceptCookies();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.BOTON_ACEPTAR_COOKIES)
        );
    }
}
