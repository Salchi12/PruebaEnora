package com.base.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ParabankLogin  extends PageObject {

    public static final Target HOME_PAGE = Target.the("pagina de inicio").located(By.xpath("//h2[text()='Customer Login']"));
    public static final Target USERNAME = Target.the("campo texto USUARIO").located(By.xpath("//input[@name='username']"));
    public static final Target  PASSWORD = Target.the("campo texto CONTRASEÑA").located(By.xpath("//input[@name='password']"));
    public static final Target  BUTTON_LOGIN = Target.the("boton INGRESAR").located(By.xpath("//input[@value='Log In']"));
    public static final Target LOGIN_PAGE = Target.the("pagina de ingreso").located(By.xpath("//h2[text()='Account Services']"));
}
