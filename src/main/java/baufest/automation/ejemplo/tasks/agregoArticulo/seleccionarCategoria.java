package baufest.automation.ejemplo.tasks.agregoArticulo;

import baufest.automation.ejemplo.userinterface.registrarCuenta.ArticuloPage;
import baufest.automation.ejemplo.userinterface.registrarCuenta.RegistroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * @author Renato Paco
 */
public class seleccionarCategoria implements Task {

    private final String articulo;

    public seleccionarCategoria(String articulo) {
        this.articulo = articulo;
    }

    @Override
    @Step("Seleccionar categoria")
    public <T extends Actor> void performAs(T actor) {
        switch (articulo){
            case "LAPTOP":
                actor.attemptsTo(
                        WaitUntil.the(ArticuloPage.BTN_LAPTOPS_CATEGORIES, isVisible()).forNoMoreThan(1500).milliseconds(),
                        Click.on((ArticuloPage.BTN_LAPTOPS_CATEGORIES))
                );
                break;
            case "PHONES":
                actor.attemptsTo(
                        WaitUntil.the(ArticuloPage.BTN_PHONES_CATEGORIES, isVisible()).forNoMoreThan(1500).milliseconds(),
                        Click.on((ArticuloPage.BTN_PHONES_CATEGORIES))
                );
                break;
            case   "MONITORS":
                actor.attemptsTo(
                        WaitUntil.the(ArticuloPage.BTN_MONITORS_CATEGORIES, isVisible()).forNoMoreThan(1500).milliseconds(),
                        Click.on((ArticuloPage.BTN_MONITORS_CATEGORIES))
                );
                break;
            default:
                System.out.println("No se encuentra categoria !!!");
        }



    }

    public static Performable withData(String articulo) {
        return instrumented(seleccionarCategoria.class, articulo);
    }

}
