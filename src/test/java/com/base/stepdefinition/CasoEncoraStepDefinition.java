package com.base.stepdefinition;

import com.base.interaction.openaccount.SelectRegisterButton;
import com.base.interaction.openaccount.SelectRegisterLink;
import com.base.model.ClientParabank;
import com.base.tasks.AbrirPaginaPrincipal;
import com.base.tasks.IngresaFormulario;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class CasoEncoraStepDefinition {

    WebDriver navegador;

    @Steps(shared = true)
    Actor actor = Actor.named("Cliente");

    @Before
    public void configuracionInicial(){
        setTheStage(new OnlineCast());
    }
    private static EnvironmentVariables environmentVariables;

    @Given("Se ingresa a la pagina de Parabank")
    public void seIngresaALaPaginaDeParabank() {
        actor.can(BrowseTheWeb.with(navegador));
        theActorCalled(actor.getName()).wasAbleTo(AbrirPaginaPrincipal.open(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("baseurl")));
        navegador = AbrirPaginaPrincipal.getDriverFromActor(actor);
    }

    @Given("Hago click en Registar")
    public void hagoClickEnRegistar() {
        actor.attemptsTo(SelectRegisterLink.click());
    }

    @When("Relleno los campos {string} {string} {string} {string} {string}{string}{string}{string}{string}{string}{string}")
    public void rellenoLosCampos(String nombre, String apellido , String direccion, String ciudad, String estado, String cod_postal, String telefono, String ssn, String usuario, String contraseña, String confirmacion) {
        ClientParabank cliente = new ClientParabank(nombre,apellido,direccion,ciudad,estado,cod_postal,telefono,ssn,usuario,contraseña,confirmacion);
        actor.attemptsTo(IngresaFormulario.enter(cliente));
    }

    @And("Doy click en el boton registar")
    public void doyClickEnElBotonRegistar() {
        actor.attemptsTo(SelectRegisterButton.click());
    }

    @Then("Aparece el mensaje de registro correcto")
    public void apareceElMensajeDeRegistroCorrecto() {
    }


}
