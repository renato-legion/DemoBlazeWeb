package baufest.automation.ejemplo.tasks.registroCuenta;

import baufest.automation.ejemplo.userinterface.registrarCuenta.RegistroPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * @author Renato Paco
 */
public class registrarCuenta implements Task {

    private final String user;
    private final String password;

    public registrarCuenta(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    @Step("{0} {0} Ingresamos datos de usuario para Registro")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(RegistroPage.INP_USUARIO_REGISTRO),
                Enter.theValue(password).into(RegistroPage.INP_PASSWORD_REGISTRO),
                Click.on(RegistroPage.BTN_SIGNUP_REGISTRO)
        );
        actor.attemptsTo(
                Hit.the(Keys.ESCAPE).keyIn(RegistroPage.BTN_SIGNUP_REGISTRO)
        );

    }

    public static Performable withData(String user, String password) {
        return instrumented(registrarCuenta.class, user, password);
    }

}
