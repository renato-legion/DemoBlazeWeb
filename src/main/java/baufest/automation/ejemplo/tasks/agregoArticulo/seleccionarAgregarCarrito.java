package baufest.automation.ejemplo.tasks.agregoArticulo;

import baufest.automation.ejemplo.userinterface.registrarCuenta.ArticuloPage;
import baufest.automation.ejemplo.userinterface.registrarCuenta.RegistroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * @author Renato Paco
 */
public class seleccionarAgregarCarrito implements Task {


    @Override
    @Step("Agregar al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ArticuloPage.BTN_ADD_TO_CART, isVisible()).forNoMoreThan(2500).milliseconds(),
                Click.on(ArticuloPage.BTN_ADD_TO_CART)
        );
        actor.attemptsTo(
                Hit.the(Keys.ESCAPE).keyIn(ArticuloPage.BTN_ADD_TO_CART)
        );

    }



}
