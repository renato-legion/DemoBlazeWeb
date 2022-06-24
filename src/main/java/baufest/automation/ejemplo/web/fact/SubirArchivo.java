package baufest.automation.ejemplo.web.fact;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class SubirArchivo {


    public void subirCarta3(String tiporesolución, String nrotramite, String tipocarta) throws InterruptedException, AWTException {

        if (tiporesolución.equals("P")) {
            //ELEMENT ADJUNTAR CARTA EN MODAL PROCEDE
            WebElement btnsubirProcede = getDriver().findElement(By.xpath("/html/body/app-assi-modal[2]/div/div/giru-proceed/div/div/div[2]/giru-cnr-proceed/div/form/giru-customer-letter/form/div[7]/div[2]/upload-letter-new/div/label/a"));

            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", btnsubirProcede);
            btnsubirProcede.click();
            Thread.sleep(5000);
        } else {
            //ELEMENT ADJUNTAR CARTA EN MODAL NO PROCEDE
            WebElement btnsubirNoProcede = getDriver().findElement(By.xpath("/html/body/app-assi-modal[2]/div/div/giru-no-proceed/div/div/div[2]/giru-default-no-proceed/form/giru-customer-letter/form/div[7]/div[2]/upload-letter-new/div/label/a"));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", btnsubirNoProcede);
            btnsubirNoProcede.click();
            Thread.sleep(5000);

        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Robot robo = new Robot();

        String fecha2 = dateFormat.format(date);
        String fechafinal = fecha2.replace("/", "");
        StringSelection str = new StringSelection(""); //P_000000000036158_20210316_TC_Procede

        if (tiporesolución.equals("P")) {

            //Copia la ruta de archivo en el portapapeles
            // StringSelection str = new StringSelection("C:\\Users\\everis\\Downloads\\"+tipocarta+"_0000000000"+nrotramite+"_"+fechafinal+"_TC_Procede.docx"); //P_000000000036158_20210316_TC_Procede
            //   StringSelection str = new StringSelection("C:\\Users\\everis\\Downloads\\\\"+tipocarta+"_0000000000"+nrotramite+"_"+fechafinal+"_TC_Procede.docx"); //P_000000000036158_20210316_TC_Procede
            if (nrotramite.length() == 4) {
                str = new StringSelection("C:\\Users\\everis\\Downloads\\\\" + tipocarta + "_00000000000" + nrotramite + "_" + fechafinal + "_TC_Procede.docx"); //P_000000000036158_20210316_TC_Procede
            } else {
                str = new StringSelection("C:\\Users\\everis\\Downloads\\\\" + tipocarta + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_Procede.docx"); //P_000000000036158_20210316_TC_Procede
            }
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
            Thread.sleep(3000);
        } else {
            //ELEMENT ADJUNTAR CARTA EN MODAL NO PROCEDE
            //  StringSelection str = new StringSelection("C:\\Users\\everis\\Downloads\\"+tipocarta+"_0000000000"+nrotramite+"_"+fechafinal+"_TC_"+tiporesolución+"_Procede.docx"); //P_000000000034133_20210317_TC_No_Procede
            //StringSelection str = new StringSelection("C:\\Users\\everis\\Downloads\\\\"+tipocarta+"_0000000000"+nrotramite+"_"+fechafinal+"_TC_"+tiporesolución+"_Procede.docx"); //P_000000000034133_20210317_TC_No_Procede
            if (nrotramite.length() == 4) {
                str = new StringSelection("C:\\Users\\everis\\Downloads\\\\" + tipocarta + "_00000000000" + nrotramite + "_" + fechafinal + "_TC_" + tiporesolución + "_Procede.docx"); //P_000000000034133_20210317_TC_No_Procede
            } else {
                str = new StringSelection("C:\\Users\\everis\\Downloads\\\\" + tipocarta + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_" + tiporesolución + "_Procede.docx"); //P_000000000034133_20210317_TC_No_Procede

            }
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
            Thread.sleep(3000);
        }

        //Presiona control+v
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);

        //Suelta control+v
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);

        //Presiona enter
        robo.keyPress(KeyEvent.VK_ENTER);

        //Suelta enter
        robo.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);


    }

    public void subirCarta2(String tipoResolucion, String nrotramite, String tipocarta) throws InterruptedException, AWTException {
        String home = System.getProperty("user.home");
        String tipoprocede = Serenity.sessionVariableCalled("tipologiaResol").toString();
        System.err.println(tipoResolucion);
        if (tipoResolucion.equals("P")) {
            //ELEMENT ADJUNTAR CARTA EN MODAL PROCEDE
            //   WebElement btnsubirProcede = getDriver().findElement(By.xpath("/html/body/app-assi-modal[2]/div/div/giru-proceed/div/div/div[2]/giru-default-proceed/form/giru-customer-letter/form/div[7]/div[2]/upload-letter-new/div/label/a"));
            WebElement btnsubirProcede = getDriver().findElement(By.xpath("/html/body/app-assi-modal[2]/div/div/giru-proceed/div/div/div[2]/giru-default-proceed/form/giru-customer-letter/form/div[6]/div[2]/upload-letter-new/div/label/a"));

            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", btnsubirProcede);
            btnsubirProcede.click();
            Thread.sleep(5000);
        } else {
            //ELEMENT ADJUNTAR CARTA EN MODAL NO PROCEDE
            //     WebElement btnsubirNoProcede = getDriver().findElement(By.xpath("/html/body/app-assi-modal[2]/div/div/giru-no-proceed/div/div/div[2]/giru-default-no-proceed/form/giru-customer-letter/form/div[7]/div[2]/upload-letter-new/div/label/a"));
            WebElement btnsubirNoProcede = getDriver().findElement(By.xpath("/html/body/app-assi-modal[2]/div/div/giru-no-proceed/div/div/div[2]/giru-default-no-proceed/form/giru-customer-letter/form/div[6]/div[2]/upload-letter-new/div/label/a"));

            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", btnsubirNoProcede);
            btnsubirNoProcede.click();
            Thread.sleep(5000);

        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Robot robo = new Robot();

        String fecha2 = dateFormat.format(date);
        String fechafinal = fecha2.replace("/", "");
        StringSelection str = new StringSelection(""); //P_000000000036158_20210316_TC_Procede
        System.err.println(tipoResolucion);
        if (tipoResolucion.equals("P")) {
            switch(tipoprocede){
                case "ProcedeCI":
                    if (nrotramite.length() == 4) {
                        str = new StringSelection(home+"\\Downloads\\" + "R" + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_Procede.docx"); //P_000000000036158_20210316_TC_Procede
                    } else {
                        str = new StringSelection(home+"\\Downloads\\" + "R" + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_Procede.docx"); //P_000000000036158_20210316_TC_Procede

                    }
                    break;
                case "ProcedeExo":
                    if (nrotramite.length() == 4) {
                        str = new StringSelection(home+"\\Downloads\\" + "P" + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_Procede.docx"); //P_000000000036158_20210316_TC_Procede
                    } else {
                        str = new StringSelection(home+"\\Downloads\\" + "P" + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_Procede.docx"); //P_000000000036158_20210316_TC_Procede

                    }
                    break;
            }
            //Copia la ruta de archivo en el portapapeles
            // StringSelection str = new StringSelection("C:\\Users\\everis\\Downloads\\"+tipocarta+"_0000000000"+nrotramite+"_"+fechafinal+"_TC_Procede.docx"); //P_000000000036158_20210316_TC_Procede
            // StringSelection str = new StringSelection("C:\\Users\\everis\\Downloads\\"+tipocarta+"_0000000000"+nrotramite+"_"+fechafinal+"_TC_Procede.docx"); //P_000000000036158_20210316_TC_Procede
/*  si va          if (nrotramite.length() == 4) {
                str = new StringSelection(home+"\\Downloads\\" + tipocarta + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_Procede.docx"); //P_000000000036158_20210316_TC_Procede
            } else {
                str = new StringSelection(home+"\\Downloads\\" + tipocarta + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_Procede.docx"); //P_000000000036158_20210316_TC_Procede

            }
            */
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
            Thread.sleep(3000);
        } else {
            switch(tipoprocede) {
                case "NoProcedeCI":
                    if (nrotramite.length() == 4) {
                        str = new StringSelection(home+"\\Downloads\\" + "R" + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_No_Procede.docx"); //P_000000000034133_20210317_TC_No_Procede
                    } else {
                        str = new StringSelection(home+"\\Downloads\\" + "R" + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_No_Procede.docx"); //P_000000000036158_20210316_TC_Procede

                    }
                    break;
                case "NoProcedeExo":
                    if (nrotramite.length() == 4) {
                        str = new StringSelection(home+"\\Downloads\\" + "P" + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_No_Procede.docx"); //P_000000000036158_20210316_TC_Procede
                    } else {
                        str = new StringSelection(home+"\\Downloads\\" + "P" + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_No_Procede.docx"); //P_000000000036158_20210316_TC_Procede

                    }
                    break;
                //ELEMENT ADJUNTAR CARTA EN MODAL NO PROCEDE
                //  StringSelection str = new StringSelection("C:\\Users\\everis\\Downloads\\"+tipocarta+"_0000000000"+nrotramite+"_"+fechafinal+"_TC_"+tiporesolución+"_Procede.docx"); //P_000000000034133_20210317_TC_No_Procede
/*siva                if (nrotramite.length() == 4) {
//auto anterior si funcion                str = new StringSelection(home+"\\Downloads\\" + tipocarta + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_" + tiporesolución + "_Procede.docx"); //P_000000000034133_20210317_TC_No_Procede
                    str = new StringSelection(home + "\\Downloads\\" + tipocarta + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_" + "No" + "_Procede.docx"); //P_000000000034133_20210317_TC_No_Procede

                } else {
                    str = new StringSelection(home + "\\Downloads\\" + tipocarta + "_0000000000" + nrotramite + "_" + fechafinal + "_TC_" + "No" + "_Procede.docx"); //P_000000000034133_20210317_TC_No_Procede

                }
 */
            }
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
            Thread.sleep(3000);

        }

        //Presiona control+v
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);

        //Suelta control+v
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);

        //Presiona enter
        robo.keyPress(KeyEvent.VK_ENTER);

        //Suelta enter
        robo.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);


    }

    public void subirArchivo() throws InterruptedException, AWTException {
        getDriver().findElement(By.xpath("//label[@class='upload-items__uploader']")).click();
        Robot robo = new Robot();

        //Copia la ruta de archivo en el portapapeles
        // StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - everis\\Documentos\\giru-automation-testing-3.0\\target\\test-classes\\ArchivoTest\\TestAuto.txt");
        StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - NTT DATA EMEAL\\Documentos\\pysteameveris-giru-automation-testing-3.0.2.UAT\\src\\test\\resources\\ArchivoTest\\TestAuto.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(3000);

        //Presiona control+v
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);

        //Suelta control+v
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);

        //Presiona enter
        robo.keyPress(KeyEvent.VK_ENTER);

        //Suelta enter
        robo.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);

     /* if (getDriver().findElement(By.xpath("//div[@class='upload-items__item-content']")).isDisplayed()) {
            assertTrue("Documento subido", true);
        } else {
            fail("Documento no fue subido");
        }*/

        WebElement btnregistrar = getDriver().findElement(By.id("claim-form__btn-submit"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true)", btnregistrar);
    }


    public void subirArchivoModal2() throws InterruptedException, AWTException {

        getDriver().findElement(By.xpath("/html/body/app-assi-modal[2]/div/div/giru-proceed/div/div/div[2]/giru-cnr-proceed/div/form/div[4]/giru-upload-files/div/div[2]/giru-upload-files-items/label/span")).click();

        Robot robo = new Robot();

        //Copia la ruta de archivo en el portapapeles
        //StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - everis\\Documentos\\giru-automation-testing-3.0\\target\\test-classes\\ArchivoTest\\TestAuto.txt");
        //StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - everis\\Documentos\\giru-automation-testing-3.0\\src\\test\\resources\\ArchivoTest\\TestAuto.txt");
        StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - NTT DATA EMEAL\\Documentos\\pysteameveris-giru-automation-testing-3.0.2.UAT\\src\\test\\resources\\ArchivoTest\\TestAuto.txt");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(3000);

        //Presiona control+v
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);

        //Suelta control+v
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);

        //Presiona enter
        robo.keyPress(KeyEvent.VK_ENTER);
        //Suelta enter
        robo.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);


    }

    public void subirArchivoModal() throws InterruptedException, AWTException {

        getDriver().findElement(By.xpath("/html/body/app-assi-modal[2]/div/div/giru-proceed/div/div/div[2]/giru-default-proceed/form/giru-upload-files/div/div[2]/giru-upload-files-items/label/span")).click();
        Robot robo = new Robot();

        //Copia la ruta de archivo en el portapapeles
        // StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - everis\\Documentos\\giru-automation-testing-3.0\\target\\test-classes\\ArchivoTest\\TestAuto.txt");
        StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - NTT DATA EMEAL\\Documentos\\pysteameveris-giru-automation-testing-3.0.2.UAT\\src\\test\\resources\\ArchivoTest\\TestAuto.txt");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(3000);

        //Presiona control+v
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);

        //Suelta control+v
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);

        //Presiona enter
        robo.keyPress(KeyEvent.VK_ENTER);
        //Suelta enter
        robo.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);


    }


    public void subirArchivoModalDer() throws InterruptedException, AWTException {

        getDriver().findElement(By.xpath("/html/body/app-assi-modal[2]/div/div/giru-proceed/div/div/div[2]/giru-validation-proceed/form/div[5]/div/giru-upload-files/div/div[2]/giru-upload-files-items/label/span")).click();
        Robot robo = new Robot();

        //Copia la ruta de archivo en el portapapeles
        // StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - everis\\Documentos\\giru-automation-testing-3.0\\target\\test-classes\\ArchivoTest\\TestAuto.txt");
        StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - NTT DATA EMEAL\\Documentos\\pysteameveris-giru-automation-testing-3.0.2.UAT\\src\\test\\resources\\ArchivoTest\\TestAuto.txt");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(3000);

        //Presiona control+v
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);

        //Suelta control+v
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);

        //Presiona enter
        robo.keyPress(KeyEvent.VK_ENTER);
        //Suelta enter
        robo.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);


    }

    public void subirArchivoModalNoProcedeDer() throws InterruptedException, AWTException {

        getDriver().findElement(By.xpath("/html/body/app-assi-modal[2]/div/div/giru-no-proceed/div/div/div[2]/giru-validation-no-proceed/form/div[5]/div/giru-upload-files/div/div[2]/giru-upload-files-items/label/span")).click();
        Robot robo = new Robot();

        //Copia la ruta de archivo en el portapapeles
        // StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - everis\\Documentos\\giru-automation-testing-3.0\\target\\test-classes\\ArchivoTest\\TestAuto.txt");
        StringSelection str = new StringSelection("C:\\Users\\XT8363\\Downloads\\Descargas\\giru-automation-testing-3.0\\src\\test\\resources\\ArchivoTest\\TestAuto.txtC:\\Users\\everis\\OneDrive - everis\\Documentos\\pysteameveris-giru-automation-testing-3.0.2.UAT\\src\\test\\resources\\ArchivoTest\\TestAuto.txt");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(3000);

        //Presiona control+v
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);

        //Suelta control+v
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);

        //Presiona enter
        robo.keyPress(KeyEvent.VK_ENTER);
        //Suelta enter
        robo.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);


    }

    public void subirArchivoModalNoProcede() throws InterruptedException, AWTException {

        getDriver().findElement(By.xpath("/html/body/app-assi-modal[2]/div/div/giru-no-proceed/div/div/div[2]/giru-default-no-proceed/form/giru-upload-files/div/div[2]/giru-upload-files-items/label/span")).click();
        Robot robo = new Robot();

        //Copia la ruta de archivo en el portapapeles
        // StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - everis\\Documentos\\giru-automation-testing-3.0\\target\\test-classes\\ArchivoTest\\TestAuto.txt");
        StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - everis\\Documentos\\pysteameveris-giru-automation-testing-3.0.2.UAT\\src\\test\\resources\\ArchivoTest\\TestAuto.txt");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(3000);

        //Presiona control+v
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);

        //Suelta control+v
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);

        //Presiona enter
        robo.keyPress(KeyEvent.VK_ENTER);
        //Suelta enter
        robo.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);


    }


    public void subirArchivoModalSeg() throws InterruptedException, AWTException {

            getDriver().findElement(By.xpath("/html/body/app-assi-modal[2]/div/div/giru-proceed/div/div/div[2]/giru-validation-proceed/form/div[5]/div/giru-upload-files/div/div[2]/giru-upload-files-items/label/span")).click();
            Robot robo = new Robot();

            //Copia la ruta de archivo en el portapapeles
            // StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - everis\\Documentos\\giru-automation-testing-3.0\\target\\test-classes\\ArchivoTest\\TestAuto.txt");
            StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - everis\\Documentos\\pysteameveris-giru-automation-testing-3.0.2.UAT\\src\\test\\resources\\ArchivoTest\\TestAuto.txt");

            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
            Thread.sleep(3000);

            //Presiona control+v
            robo.keyPress(KeyEvent.VK_CONTROL);
            robo.keyPress(KeyEvent.VK_V);

            //Suelta control+v
            robo.keyRelease(KeyEvent.VK_CONTROL);
            robo.keyRelease(KeyEvent.VK_V);

            //Presiona enter
            robo.keyPress(KeyEvent.VK_ENTER);
            //Suelta enter
            robo.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(5000);



    }

    public void subirArchivoModalNoProcedeSeg()  throws InterruptedException, AWTException {
        getDriver().findElement(By.xpath("/html/body/app-assi-modal[2]/div/div/giru-no-proceed/div/div/div[2]/giru-validation-no-proceed/form/div[5]/div/giru-upload-files/div/div[2]/giru-upload-files-items/label/span")).click();
        Robot robo = new Robot();

        //Copia la ruta de archivo en el portapapeles
        // StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - everis\\Documentos\\giru-automation-testing-3.0\\target\\test-classes\\ArchivoTest\\TestAuto.txt");
        StringSelection str = new StringSelection("C:\\Users\\everis\\OneDrive - everis\\Documentos\\pysteameveris-giru-automation-testing-3.0.2.UAT\\src\\test\\resources\\ArchivoTest\\TestAuto.txt");

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Thread.sleep(3000);

        //Presiona control+v
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);

        //Suelta control+v
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);

        //Presiona enter
        robo.keyPress(KeyEvent.VK_ENTER);
        //Suelta enter
        robo.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
    }


}