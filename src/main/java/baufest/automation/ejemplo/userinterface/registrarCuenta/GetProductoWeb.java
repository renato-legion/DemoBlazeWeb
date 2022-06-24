package baufest.automation.ejemplo.userinterface.registrarCuenta;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GetProductoWeb extends PageObject {
    @FindBy(css = "body > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h4:nth-child(1) > a:nth-child(1)")
    WebElement TEXTO_PRIMER_PRODUCTO;


    @FindBy(css = "body > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h5:nth-child(2)")
    WebElement PRECIO_PRIMER_PRODUCTO;

    static String nombreProducto=null;
    static String PrecioProducto=null;

    public void seteaNombreProducto(){
        nombreProducto=TEXTO_PRIMER_PRODUCTO.getText();
        System.out.println("NOMBRE PRODUCTO: "+ nombreProducto);
   }

    public void seteaPrecioProducto(){
        PrecioProducto=PRECIO_PRIMER_PRODUCTO.getText();
        PrecioProducto = PrecioProducto.replace("$","");
        System.out.println("PRECIO PRODUCTO: "+ PrecioProducto);
    }


   public String getNombreProducto(){
        return nombreProducto;
   }

    public String getPrecioProducto(){
        return PrecioProducto;
    }

}
