package baufest.automation.ejemplo.web.fact;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class Shadow extends PageObject {

    public SearchContext expandRootElement(WebElement element) {


       SearchContext shadowRoot = element.getShadowRoot();
       return shadowRoot;
    //    return (WebElement) ((JavascriptExecutor) getDriver())
    //            .executeScript("return arguments[0].shadowRoot", element);
    }

  /*  public WebElement expandRootElement(WebElement shadowHost) {
        WebElement returnObj = null;
        Object shadowRoot = ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].shadowRoot", shadowHost);
        if (shadowRoot instanceof WebElement) {
            // ChromeDriver 95
            returnObj = (WebElement) shadowRoot;
        }
        else if (shadowRoot instanceof Map)  {
            // ChromeDriver 96+
            // Based on https://github.com/SeleniumHQ/selenium/issues/10050#issuecomment-974231601
            Map<String, Object> shadowRootMap = (Map<String, Object>) shadowRoot;
            String shadowRootKey = (String) shadowRootMap.keySet().toArray()[0];
            String id = (String) shadowRootMap.get(shadowRootKey);
            RemoteWebElement remoteWebElement = new RemoteWebElement();
            remoteWebElement.setParent((RemoteWebDriver) getDriver());
            remoteWebElement.setId(id);
            returnObj = remoteWebElement;
        }
        else {
         //   Assert.fail("Unexpected return type for shadowRoot in expandRootElement()");
        }
        return returnObj;
    }
*/

    public WebElement expandContainer(String numeroCss, WebElement elementoBase, String elemento1, String elemento2, String elemento3) {
        WebElement resultado = null;
        switch (numeroCss) {
            case "1css": {
                SearchContext shadowRoot = expandRootElement(elementoBase);
                resultado = shadowRoot.findElement(By.cssSelector(elemento1));
             break;
            }
            case "2css": {
                SearchContext shadowRoot1 = expandRootElement(elementoBase);
                WebElement rootGenerico = shadowRoot1.findElement(By.cssSelector(elemento1));
                SearchContext shadowRoot2 = expandRootElement(rootGenerico);
                resultado = shadowRoot2.findElement(By.cssSelector(elemento2));
                break;
            }
            case "3css": {
                SearchContext shadowRoot1 = expandRootElement(elementoBase);
                WebElement rootGenerico = shadowRoot1.findElement(By.cssSelector(elemento1));
                SearchContext shadowRoot2 = expandRootElement(rootGenerico);
                WebElement rootGenerico2 = shadowRoot2.findElement(By.cssSelector(elemento2));
                SearchContext shadowRoot3 = expandRootElement(rootGenerico2);
                resultado = shadowRoot3.findElement(By.cssSelector(elemento3));
                break;
            }
            case "2cssid": {
                SearchContext shadowRoot1 = expandRootElement(elementoBase);
                WebElement rootGenerico = shadowRoot1.findElement(By.cssSelector(elemento1));
                SearchContext shadowRoot2 = expandRootElement(rootGenerico);
                resultado = shadowRoot2.findElement(By.id(elemento2));
                break;
            }
            case "1className": {
                SearchContext shadowRoot1 = expandRootElement(elementoBase);
                resultado = shadowRoot1.findElement(By.className(elemento1));
                break;
            }
            case "1id": {
                SearchContext shadowRoot = expandRootElement(elementoBase);
                resultado = shadowRoot.findElement(By.id(elemento1));
                break;
            }
        }
        return resultado;
    }
}
