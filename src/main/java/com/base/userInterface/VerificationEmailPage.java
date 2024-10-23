package com.base.userInterface;


import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


public class VerificationEmailPage extends PageObject {

    public static final Target MENSAJE_CORREO_VERIFICACION = Target.the("Mensaje de correo de verificación ").located(By.xpath("//*[@id='form']/h2"));

}
