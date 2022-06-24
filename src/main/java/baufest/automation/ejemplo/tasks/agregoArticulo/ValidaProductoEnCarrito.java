package baufest.automation.ejemplo.tasks.agregoArticulo;

import baufest.automation.ejemplo.questions.ArticuloQuestions;
import baufest.automation.ejemplo.userinterface.registrarCuenta.GetProductoWeb;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


public class ValidaProductoEnCarrito implements Task {

    GetProductoWeb getProductoWeb = new GetProductoWeb();
    static String nombreProductoTask=null;
    static String PrecioProductoTask=null;


    @Override
    public <T extends Actor> void performAs(T actor) {
        nombreProductoTask=getProductoWeb.getNombreProducto();
        PrecioProductoTask=getProductoWeb.getPrecioProducto();


        theActorInTheSpotlight().should(
                seeThat(ArticuloQuestions.carritoPrecioArticulo(), equalTo(PrecioProductoTask))
        );
        theActorInTheSpotlight().should(
                seeThat(ArticuloQuestions.carritoNombreArticulo(), equalTo(nombreProductoTask))
        );
        theActorInTheSpotlight().should(
                seeThat(ArticuloQuestions.carritoPrecioFinalArticulo(), equalTo(PrecioProductoTask))
        );

    }


}
