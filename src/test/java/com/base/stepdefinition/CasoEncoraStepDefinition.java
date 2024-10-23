package com.base.stepdefinition;

import com.base.interaction.homepage.SelectLogIn;
import com.base.interaction.openaccount.SelectLogOut;
import com.base.interaction.openaccount.SelectRegisterButton;
import com.base.interaction.openaccount.SelectRegisterLink;
import com.base.model.ClientParabank;
import com.base.model.UsuarioParabank;
import com.base.question.ElementIsVisible;
import com.base.tasks.AbrirPaginaPrincipal;
import com.base.tasks.IngresaFormulario;
import com.base.tasks.IngresarCredenciales;
import com.base.userInterface.ParabankCreateAccount;
import com.base.userInterface.ParabankLogin;
import com.base.util.Util;
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
import org.junit.Assert;
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

    @And("Relleno los campos {string} {string} {string} {string} {string}{string}{string}{string}{string}{string}{string}")
    public void rellenoLosCampos(String nombre, String apellido , String direccion, String ciudad, String estado, String cod_postal, String telefono, String ssn, String usuario, String contraseña, String confirmacion) {
        ClientParabank cliente = new ClientParabank(nombre,apellido,direccion,ciudad,estado,cod_postal,telefono,ssn,usuario,contraseña,confirmacion);
        actor.attemptsTo(IngresaFormulario.enter(cliente));
    }

    @And("Doy click en el boton registar")
    public void doyClickEnElBotonRegistar() {
        actor.attemptsTo(SelectRegisterButton.click());
    }

    @And("Aparece el mensaje de registro correcto y regreso al inicio")
    public void apareceElMensajeDeRegistroCorrecto() {
        String message = "Your account was created successfully. You are now logged in.";
        String getMessage = Util.getTextFromElement(navegador, ParabankCreateAccount.MESSAGE_OK);
        boolean result = getMessage.equals(message);
        if (result){
            actor.attemptsTo(SelectLogOut.click());
        }
        Assert.assertTrue(result);
    }


    @When("Estoy en la pagina de inicio")
    public void estoyEnLaPaginaDeInicio() {
        ElementIsVisible.onThePage(ParabankLogin.HOME_PAGE);
    }

    @And("Ingreso mis credenciales {string} y {string}")
    public void ingresoMisCredencialesY(String usuario, String contrasena) {
        UsuarioParabank cliente = new UsuarioParabank(usuario,contrasena);
        actor.attemptsTo(IngresarCredenciales.enter(cliente));
        actor.attemptsTo(SelectLogIn.click());
    }

    @Then("Hago un logeo exitoso")
    public void hagoUnLogeoExitoso() {
        ElementIsVisible.onThePage(ParabankLogin.LOGIN_PAGE);
    }
}
