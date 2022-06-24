package baufest.automation.ejemplo.tasks.login;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * @author Renato Paco
 */
public class AbrirDemoblaze implements Task {

    EnvironmentVariables environmentVariables;

    private final String url;

    public AbrirDemoblaze(String url) {
        this.url = url;
    }

    @Override
    @Step("{0} Inicia la página #url")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(url))
        );
    }

    public static Task loginDemozablePage() {
        String url = "demozable.page";
        return instrumented(AbrirDemoblaze.class, url);
    }

}
