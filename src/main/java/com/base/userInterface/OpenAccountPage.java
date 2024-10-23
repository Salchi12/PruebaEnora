package com.base.userInterface;


import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;



public class OpenAccountPage extends PageObject {

    public static final Target CAMPO_DNI = Target.the("campo de texto de DNI").located(By.xpath("//*[@id='idni']"));
    public static final Target CAMPO_CORREO = Target.the("campo de texto de CORREO").located(By.xpath("//*[@id='iemail']"));
    public static final Target CAMPO_TELEFONO = Target.the("campo de texto de TELEFONO").located(By.xpath("//*[@id='po-input']"));
    public static final Target CHECK_AUTORIZACION = Target.the("check de autorizacion").located(By.xpath("//label[contains(text(), 'He leído y acepto la')]"));
    public static final Target BOTON_SIGUIENTE_ABRIR_CUENTA = Target.the("boton siguiente").located(By.xpath("//span[contains(text(),'Siguiente')]"));

}
