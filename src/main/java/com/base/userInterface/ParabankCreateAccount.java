package com.base.userInterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


public class ParabankCreateAccount extends PageObject {

    public static final Target LINK_REGISTER = Target.the("link registro").located(By.xpath("//a[contains(text(),'Register')]"));
    public static final Target FIRST_NAME = Target.the("campo texto NOMBRE").located(By.xpath("//input[@id='customer.firstName']"));
    public static final Target LAST_NAME = Target.the("campo texto APELLIDO").located(By.xpath("//input[@id='customer.lastName']"));
    public static final Target ADDRESS = Target.the("campo texto DIRECCION").located(By.xpath("//input[@id='customer.address.street']"));
    public static final Target CITY = Target.the("campo texto CIUDAD").located(By.xpath("//input[@id='customer.address.city']"));
    public static final Target STATE = Target.the("campo texto ESTADO").located(By.xpath("//input[@id='customer.address.state']"));
    public static final Target ZIP_CODE = Target.the("campo texto CODIGO POSTAL").located(By.xpath("//input[@id='customer.address.zipCode']"));
    public static final Target PHONE_NUMBER = Target.the("campo texto TELEFONO").located(By.xpath("//input[@id='customer.phoneNumber']"));
    public static final Target SSN = Target.the("campo texto SSN").located(By.xpath("//input[@id='customer.ssn']"));
    public static final Target USERNAAME = Target.the("campo texto USUARIO").located(By.xpath("//input[@id='customer.username']"));
    public static final Target PASSWORD = Target.the("campo texto CONTRASEÑA").located(By.xpath("//input[@id='customer.password']"));
    public static final Target  PASSWORD_CONFIRM = Target.the("campo texto CONFIRMAR_CONTRASEÑA").located(By.xpath("//input[@id='repeatedPassword']"));
    public static final Target  BUTTON_REGISTER = Target.the("boton REGISTAR").located(By.xpath("//input[@value='Register']"));


}
