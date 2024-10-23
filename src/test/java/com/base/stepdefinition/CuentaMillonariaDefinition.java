package com.base.stepdefinition;

import com.base.interaction.homepage.SelectOpenAccount;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import com.base.interaction.openaccount.SelectAcceptPolicies;
import com.base.interaction.openaccount.SelectGoNext;
import com.base.interaction.homepage.SelectAcceptCookies;
import com.base.model.Client;
import com.base.question.ElementIsVisible;
import com.base.tasks.AbrirPaginaPrincipal;
import com.base.tasks.IngresarDatosPersonales;
import com.base.userInterface.HomePage;
import com.base.userInterface.VerificationEmailPage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import pe.interbank.dso.util.Util;

public class CuentaMillonariaDefinition {

    
    WebDriver navegador;

    @Steps(shared = true)
    Actor actor = Actor.named("Cliente");

    @Before
    public void configuracionInicial(){
        setTheStage(new OnlineCast());
    }
    private static EnvironmentVariables environmentVariables;

    @Given("Se ingresa a la pagina de interbank")
    public  void userNavegateTo()  throws Exception{
        actor.can(BrowseTheWeb.with(navegador));
        theActorCalled(actor.getName()).wasAbleTo(AbrirPaginaPrincipal.open(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("baseurl")));
        navegador = AbrirPaginaPrincipal.getDriverFromActor(actor);
    }


    @Given("selecciona abre tu cuenta")
    public void seleccionaAbreTuCuenta() throws Exception {
        theActorInTheSpotlight().attemptsTo(
            SelectAcceptCookies.click()
        );

        theActorInTheSpotlight().attemptsTo(
            SelectOpenAccount.click()
         );
    }
    @When("digito mi dni {string} correo {string} celular {string}")
    public void digitoMiDniCorreoCelular(String dni, String correo, String celular) throws Exception{
        // Write code here that turns the phrase above into concrete actions
        Client client= new Client(dni,correo,celular);
        theActorInTheSpotlight().attemptsTo(
                IngresarDatosPersonales.enter(client)
                );
    }
    @When("selecciono la opción siguiente")
    public void seleccionoOpcionSiguiente() {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(SelectAcceptPolicies.click(),
                SelectGoNext.click()
        );
    }

    @Then("el sistema me debe mostrar la pantalla de identificacion {string}")
    public void elSistemaMeDebeMostrarLaPantallaDeIdentificacion(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat(ElementIsVisible.onThePage((VerificationEmailPage.MENSAJE_CORREO_VERIFICACION)))
        );
    }


}
