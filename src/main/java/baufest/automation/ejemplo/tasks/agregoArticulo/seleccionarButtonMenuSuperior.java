package baufest.automation.ejemplo.tasks.agregoArticulo;

import baufest.automation.ejemplo.userinterface.registrarCuenta.ArticuloPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * @author Renato Paco
 */
public class seleccionarButtonMenuSuperior implements Task {

    private final String seccionMenuSuperior;

    public seleccionarButtonMenuSuperior(String seccionMenuSuperior) {
        this.seccionMenuSuperior = seccionMenuSuperior;
    }

    @Override
    @Step("Click en Menu Superior")
    public <T extends Actor> void performAs(T actor) {

        switch (seccionMenuSuperior){
            case "Home":
                actor.attemptsTo(
                        WaitUntil.the(ArticuloPage.BTN_HOME, isVisible()).forNoMoreThan(15).seconds(),
                        Click.on(ArticuloPage.BTN_HOME)
                );
                break;
            case "Cart":
                actor.attemptsTo(
                        WaitUntil.the(ArticuloPage.BTN_CART, isVisible()).forNoMoreThan(15).seconds(),
                        Click.on(ArticuloPage.BTN_CART)
                );
                break;
            default:
                System.out.println("No se encuentra botón.");
        }


    }
    public static Performable withData(String seccionMenuSuperior) {
        return instrumented(seleccionarButtonMenuSuperior.class, seccionMenuSuperior);
    }

}
