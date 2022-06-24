package baufest.automation.ejemplo.stepsdefinitions.login;


import baufest.automation.ejemplo.tasks.agregoArticulo.seleccionarButtonMenuSuperior;
import baufest.automation.ejemplo.tasks.agregoArticulo.*;
import baufest.automation.ejemplo.tasks.login.*;
import baufest.automation.ejemplo.tasks.registroCuenta.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinitions {

String UserNameGlobal = null;
    String PasswordGlobal = null;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^que el (.*) accede a la aplicacion DemoBlaze$")
    public void validaUsuarioAccedeAplicacionGiru(String usuario) {
        theActorCalled(usuario).attemptsTo(
                AbrirDemoblaze.loginDemozablePage()
        );
    }
    @When("^se registra con usuario (.*) y contrasena (.*)$")
    public void registroNuevoUsuarioContrasena(String user, String password) throws InterruptedException {
        Thread.sleep(500);
        theActorInTheSpotlight().attemptsTo(
                new ButtonSignUp()
        );

        theActorInTheSpotlight().attemptsTo(
                registrarCuenta.withData(user, password)
        );
        UserNameGlobal=user;
        PasswordGlobal=password;

        System.out.println("hola");

        Thread.sleep(500);

    }
    @And("realiza la actividad login y logut con el nuevo usuario")
    public void realizaLoginyLogout() throws InterruptedException {

        System.out.println("USUARIO CREADO: "+ UserNameGlobal + "\nPASSWORD GLOBAL: "+PasswordGlobal);
        theActorInTheSpotlight().attemptsTo(
                new ButtonLogin()
        );

        theActorInTheSpotlight().attemptsTo(
                iniciarSesion.withData(UserNameGlobal,PasswordGlobal )
        );
        theActorInTheSpotlight().attemptsTo(
                new ButtonLogOut()
        );

        Thread.sleep(500);
    }

    @And("^inicia sesion con usuario (.*) y contrasena (.*)$")
    public void iniciaSesion(String user, String password){
        theActorInTheSpotlight().attemptsTo(
                new ButtonLogin()
        );
        theActorInTheSpotlight().attemptsTo(
                iniciarSesion.withData(user,password )
        );

    }

    @And("^agrega el articulo (.*)$")
    public void agregaArticulo(String articulo) throws InterruptedException {
        Thread.sleep(500);
        theActorInTheSpotlight().attemptsTo(
            new seleccionarButtonMenuSuperior("Home")
        );
        Thread.sleep(500);
        theActorInTheSpotlight().attemptsTo(
                seleccionarCategoria.withData(articulo)
        );
        Thread.sleep(500);
        theActorInTheSpotlight().attemptsTo(
               new seleccionarPrimerArticulo()
        );
        Thread.sleep(500);
        theActorInTheSpotlight().attemptsTo(
                new seleccionarAgregarCarrito()
        );
        Thread.sleep(500);


    }


    @Then("valida que se haya agregado al carrito")
    public void validaHistoricoAtencionRealizadaE2E() throws InterruptedException {
        theActorInTheSpotlight().attemptsTo(
                new seleccionarButtonMenuSuperior("Cart")
        );
        Thread.sleep(500);
        theActorInTheSpotlight().attemptsTo(
                new ValidaProductoEnCarrito()
        );

    }
}




