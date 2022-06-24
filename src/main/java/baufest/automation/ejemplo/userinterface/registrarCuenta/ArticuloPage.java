package baufest.automation.ejemplo.userinterface.registrarCuenta;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * @author Renato Paco
 */
public class ArticuloPage {
/////////////////////////////////==========HOME==========/////////////////////////////////
    public static final Target BTN_HOME = Target.the("Botón HOME").located(By.cssSelector("li[class='nav-item active'] a[class='nav-link']"));

    public static final Target BTN_CART = Target.the("Botón CART").located(By.cssSelector("#cartur"));
    /////////////////////////////////==========CATEGORIAS==========/////////////////////////////////
    public static final Target BTN_PHONES_CATEGORIES = Target.the("PHONES").located(By.linkText("Phones"));
    public static final Target BTN_LAPTOPS_CATEGORIES = Target.the("LAPTOP").located(By.linkText("Laptops"));
    public static final Target BTN_MONITORS_CATEGORIES = Target.the("MONITORS").located(By.linkText("Monitors"));

    /////////////////////////////////==========ARTICULOS==========/////////////////////////////////
    public static final Target IMG_PRIMERARTICULO = Target.the("Primer Articulo").located(By.cssSelector("div[id='tbodyid'] div:nth-child(1) div:nth-child(1) a:nth-child(1) img:nth-child(1)"));

    /////////////////////////////////==========AGREGAR CARRITO==========/////////////////////////////////

    public static final Target BTN_ADD_TO_CART = Target.the("ADD TO CART").located(By.linkText("Add to cart"));
    public static final Target TXT_CARRITO_PRECIO = Target.the("Precio carrito").located(By.cssSelector("td:nth-child(3)"));
    public static final Target TXT_CARRITO_NOMBRE= Target.the("Primer Articulo").located(By.cssSelector("td:nth-child(2)"));
    public static final Target TXT_CARRITO_PRECIOFINAL = Target.the("Primer Articulo").located(By.cssSelector("#totalp"));



    public static final Target LBL_ESPECIALISTA = Target.the("Perfil especialista").located(By.cssSelector(".title"));

}
