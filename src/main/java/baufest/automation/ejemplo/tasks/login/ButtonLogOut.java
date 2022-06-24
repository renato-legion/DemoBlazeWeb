package baufest.automation.ejemplo.tasks.login;

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
public class ButtonLogOut implements Task {

    @Override
    @Step("Click en LogOUT")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(RegistroPage.BTN_LOGOUT, isVisible()).forNoMoreThan(1500).milliseconds(),
                Click.on(RegistroPage.BTN_LOGOUT)
        );
    }

}
