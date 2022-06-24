package baufest.automation.ejemplo.tasks.registroCuenta;

import baufest.automation.ejemplo.userinterface.registrarCuenta.RegistroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * @author Renato Paco
 */
public class ButtonSignUp implements Task {

    @Override
    @Step("Click en SignUp")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(RegistroPage.BTN_SIGNUP, isVisible()).forNoMoreThan(100).milliseconds(),
                Click.on(RegistroPage.BTN_SIGNUP)
        );
    }

}
