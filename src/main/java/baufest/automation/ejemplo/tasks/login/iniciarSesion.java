package baufest.automation.ejemplo.tasks.login;

import baufest.automation.ejemplo.userinterface.registrarCuenta.RegistroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * @author Renato Paco
 */
public class iniciarSesion implements Task {

    private final String user;
    private final String password;

    public iniciarSesion(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    @Step("{0} {0} Ingresamos datos de usuario")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(RegistroPage.INP_USUARIO_LOGIN),
                Enter.theValue(password).into(RegistroPage.INP_PASSWORD_LOGIN).thenHit(Keys.ENTER),
                Click.on(RegistroPage.BTN_LOGIN_INICIARSESION)
        );

    }

    public static Performable withData(String user, String password) {
        return instrumented(iniciarSesion.class, user, password);
    }

}
