package com.base.userInterface;


import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;



public class HomePage extends PageObject {


    public static final Target BOTON_ACEPTAR_COOKIES = Target.the("boton limpiar cookis").located(By.xpath("//*[contains(text(),'Aceptar Cookies')]"));
    public static final Target BOTON_ABRIR_CUENTA = Target.the("boton de abrir cuenta").located(By.xpath("//span[normalize-space()='ABRE TU CUENTA']"));

    public static final Target BOTON_MILLAS = Target.the("boton millas").located(By.xpath("//p[text()='Conoce todo para seguir disfrutando de visitas gratis e ilimitadas a Salones Vip Internacionales.']"));
    public static final Target BOTON_GLOBALNET = Target.the("bton global").located(By.xpath("//a[text()='GlobalNet']"));
}
