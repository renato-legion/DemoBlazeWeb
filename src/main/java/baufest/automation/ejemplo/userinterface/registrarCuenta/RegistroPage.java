package baufest.automation.ejemplo.userinterface.registrarCuenta;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * @author Renato Paco
 */
public class RegistroPage {
/////////////////////////////////==========REGISTRO==========/////////////////////////////////
    public static final Target INP_USUARIO_REGISTRO = Target.the("Usuario").located(By.id("sign-username"));
    public static final Target INP_PASSWORD_REGISTRO = Target.the("Contraseña").located(By.id("sign-password"));
    public static final Target BTN_SIGNUP = Target.the("Boton Menu Registrar").located(By.linkText("Sign up"));
    public static final Target BTN_SIGNUP_REGISTRO = Target.the("Botón registrar").located(By.cssSelector("button[onclick='register()']"));
    /////////////////////////////////==========LOGIN==========/////////////////////////////////
    public static final Target INP_USUARIO_LOGIN = Target.the("Usuario").located(By.id("loginusername"));
    public static final Target INP_PASSWORD_LOGIN = Target.the("Contraseña").located(By.id("loginpassword"));
    public static final Target BTN_LOGIN = Target.the("Boton Menu Login").located(By.id("login2"));
    public static final Target BTN_LOGIN_INICIARSESION = Target.the("Botón iniciar sesion").located(By.cssSelector("button[onclick='logIn()']"));

    /////////////////////////////////==========LOGOUT==========/////////////////////////////////
    public static final Target BTN_LOGOUT = Target.the("Boton Menu LogOut").located(By.cssSelector("#logout2"));


}
