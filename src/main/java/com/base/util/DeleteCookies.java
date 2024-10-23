package pe.interbank.dso.util;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class DeleteCookies implements Performable {
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.manage().deleteAllCookies();
    }

    public static DeleteCookies fromBrowser() {
        return new DeleteCookies();
    }
}