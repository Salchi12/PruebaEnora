package pe.interbank.dso.util;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {
//    public Boolean validarVisibilidadElemento(WebDriver webDriver, String xPath){
//        Boolean valor = false;
//        WebElement webElement;
//        webElement=webDriver.findElement(By.xpath(xPath));
//        valor=webElement.isDisplayed();
//        return valor;
//    }


    public static void highlightElement(WebDriver driver, Target target) {
       
        try {
//            System.out.println("target :" + target.toString());
//            System.out.println("Driver Title:" + driver.getTitle());
//            System.out.println("Driver getWindowHandle:" + driver.getWindowHandle());
            WebElement element = target.resolveFor(driver);
//            System.out.println("Element :" + element.getText());
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            if (element == null) {
//                System.out.println("Element is null");
//            }
//            if (!element.isDisplayed()) {
//                System.out.println("Element is not displayed");
//            }
////            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            wait.until(ExpectedConditions.elementToBeClickable(element));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            String originalStyle = element.getAttribute("style");
            js.executeScript("arguments[0].style.border = '3px solid red';", element);

            // Espera de 1 segundo para que el resaltado sea visible
            Thread.sleep(2000);

            // Restaura el estilo original
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);

        } catch (Exception e) {
            System.out.println("An error occurred while highlighting the element: " + e.getMessage());
        }
    }

    public static void scrollToElement(WebDriver driver, Target target){
        WebElement element = target.resolveFor(driver);
        System.out.println("Element :" + element.getText());
        if (element == null) {
            System.out.println("Element is null");
        }
        assert element != null;
        if (!element.isDisplayed()) {
            System.out.println("Element is not displayed");
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static void scrollToElementAndClick(WebDriver driver, Target target) {
        scrollToElement(driver, target);
        WebElement element = target.resolveFor(driver);
        element.click();
    }

    //revisar datapicker


}
