package baufest.automation.ejemplo.questions;

import baufest.automation.ejemplo.userinterface.registrarCuenta.ArticuloPage;
import net.serenitybdd.screenplay.Question;
public class ArticuloQuestions {

    public static Question<String> carritoPrecioArticulo() {
        return actor -> ArticuloPage.TXT_CARRITO_PRECIO.resolveFor(actor).waitUntilVisible().getText();
    }
    public static Question<String> carritoNombreArticulo() {
        return actor -> ArticuloPage.TXT_CARRITO_NOMBRE.resolveFor(actor).waitUntilVisible().getText();
    }
    public static Question<String> carritoPrecioFinalArticulo() {
        return actor -> ArticuloPage.TXT_CARRITO_PRECIOFINAL.resolveFor(actor).waitUntilVisible().getText();
    }
}
