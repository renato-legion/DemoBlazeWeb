package baufest.automation.ejemplo.tasks.agregoArticulo;

import baufest.automation.ejemplo.userinterface.registrarCuenta.ArticuloPage;
import baufest.automation.ejemplo.userinterface.registrarCuenta.GetProductoWeb;
import baufest.automation.ejemplo.userinterface.registrarCuenta.RegistroPage;
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
public class seleccionarPrimerArticulo implements Task {
    GetProductoWeb getProductoWeb = new GetProductoWeb();

    @Override
    @Step("Seleccionar primer articulo")
    public <T extends Actor> void performAs(T actor) {
        getProductoWeb.seteaNombreProducto();
        getProductoWeb.seteaPrecioProducto();
        actor.attemptsTo(
                WaitUntil.the(ArticuloPage.IMG_PRIMERARTICULO, isVisible()).forNoMoreThan(4500).milliseconds(),
                Click.on(ArticuloPage.IMG_PRIMERARTICULO)
        );


    }



}
