package com.base.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ParabankLogin  extends PageObject {

    public static final Target USERNAME = Target.the("campo texto USUARIO").located(By.xpath("//input[@name='username']"));
    public static final Target  PASSWORDM = Target.the("campo texto CONTRASEÑA").located(By.xpath("//input[@name='password']"));
    public static final Target  BUTTON_LOGIN = Target.the("boton INGRESAR").located(By.xpath("//input[@value='Log In']"));
}
