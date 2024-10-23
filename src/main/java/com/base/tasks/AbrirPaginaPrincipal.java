package com.base.tasks;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.webdriver.WebDriverFacade;
public class AbrirPaginaPrincipal implements Task {




    private String url;

    public AbrirPaginaPrincipal(String url) {
        this.url = url;
    }

    public static AbrirPaginaPrincipal open(String url) {
        return new AbrirPaginaPrincipal(url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url));
    }

    public static WebDriver getDriverFromActor(Actor actor) {
        return ((WebDriverFacade) actor.usingAbilityTo(net.serenitybdd.screenplay.abilities.BrowseTheWeb.class).getDriver()).getProxiedDriver();
    }

}
