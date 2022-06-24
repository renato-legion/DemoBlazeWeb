package baufest.automation.ejemplo.web.fact;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Util extends PageObject {

    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    private Shadow general;

    @FindBy(id = "dashboard__menus")
    WebElement btnTodosLosTramites;

    @FindBy(id = "dashboard__menus")
    WebElement btnTramites;

    public String getVariableSerenity(String tipoVariable) {
        return EnvironmentSpecificConfiguration.from(variables).getProperty(tipoVariable);
    }


    public void menuSuperior(String Menu) {
        String BotonAdministrador = "";
        WebElement btnTramitesSh = null;
        // WebElement menuSuperior = general.expandContainer("2css", btnTodosLosTramites, "ibk-link", "p", "");
        WebElement menuSuperior = getDriver().findElement(By.xpath("//*[@id=\"menus\"]/div[1]/a"));
        BotonAdministrador = menuSuperior.getText();
        System.out.println(BotonAdministrador);
        if (BotonAdministrador.trim().equalsIgnoreCase("ADMINISTRADOR")) {
            switch (Menu) {
                case "Administrador":
                    //btnTramitesSh = general.expandContainer("1css", btnTramites, "div > div > div:nth-child(1) > ibk-link", "", "");
                    getDriver().findElement(By.xpath("//*[@id=\"menus\"]/div[1]/a")).click();
                    break;
                case "Dashboard":
                    // btnTramitesSh = general.expandContainer("1css", btnTramites, "div > div > div:nth-child(2) > ibk-link", "", "");
                    getDriver().findElement(By.xpath("//*[@id=\"menus\"]/div[2]/a")).click();
                    break;
                case "Tramites":
                    // btnTramitesSh = general.expandContainer("1css", btnTramites, "div > div > div:nth-child(3) > ibk-link", "", "");
                    getDriver().findElement(By.xpath("//*[@id=\"menus\"]/div[3]/a")).click();
                    break;
                case "Atencion al Cliente":
                    // btnTramitesSh = general.expandContainer("1css", btnTramites, "div > div > div:nth-child(4) > ibk-link", "", "");
                    getDriver().findElement(By.xpath("//*[@id=\"menus\"]/div[4]/a")).click();
                    break;
                case "Historial":
                    //btnTramitesSh = general.expandContainer("1css", btnTramites, "div > div > div:nth-child(5) > ibk-link", "", "");
                    getDriver().findElement(By.xpath("//*[@id=\"menus\"]/div[5]/a")).click();
                    break;
                default:
            }
              ///  assert btnTramitesSh != null;
            //  btnTramitesSh.click();

        } else if (BotonAdministrador.trim().equalsIgnoreCase("DASHBOARD")) {
            switch (Menu) {
                case "Dashboard":
                    // btnTramitesSh = general.expandContainer("1css", btnTramites, "div > div > div:nth-child(1) > ibk-link", "", "");
                    getDriver().findElement(By.xpath("//*[@id=\"menus\"]/div[1]/a")).click();
                    break;
                case "Tramites":
                    //   btnTramitesSh = general.expandContainer("1css", btnTramites, "div > div > div:nth-child(2) > ibk-link", "", "");
                    getDriver().findElement(By.xpath("//*[@id=\"menus\"]/div[2]/a")).click();
                    break;
                case "Atencion al Cliente":
                    //btnTramitesSh = general.expandContainer("1css", btnTramites, "div > div > div:nth-child(3) > ibk-link", "", "");
                    getDriver().findElement(By.xpath("//*[@id=\"menus\"]/div[3]/a")).click();

                    break;
                case "Historial":
                    //btnTramitesSh = general.expandContainer("1css", btnTramites, "div > div > div:nth-child(4) > ibk-link", "", "");
                    getDriver().findElement(By.xpath("//*[@id=\"menus\"]/div[4]/a")).click();
                    break;
                default:
            }
            //assert btnTramitesSh != null;
           // btnTramitesSh.click();

        } else if (BotonAdministrador.trim().equalsIgnoreCase(" ATENCIÓN AL CLIENTE ")) {
            switch (Menu) {
                case "Atencion al Cliente":
                    //btnTramitesSh = general.expandContainer("1css", btnTramites, "div > div > div:nth-child(1) > ibk-link", "", "");
                    getDriver().findElement(By.xpath("//*[@id=\"menus\"]/div[1]/a")).click();
                    break;
                case "Historial":
                    //btnTramitesSh = general.expandContainer("1css", btnTramites, "div > div > div:nth-child(2) > ibk-link", "", "");
                    getDriver().findElement(By.xpath("//*[@id=\\\"menus\\\"]/div[2]")).click();
                    break;
            }
            assert btnTramitesSh != null;
            btnTramitesSh.click();
        }
    }


    public String separarValoresTrama(int iCantidadArreglos, String sCadena, String sCaracter) {
        String sCadenaObtenida = "";
        try {
            String[] arrCadenaObtenida;
            arrCadenaObtenida = sCadena.split(sCaracter, -1);
            sCadenaObtenida = arrCadenaObtenida[iCantidadArreglos];
        } catch (Exception e) {
            System.out.println("Error en el metodo SepararValoresTrama" + e.getMessage());
        }
        return sCadenaObtenida;
    }

    public int retornarCantidadValoresTrama(String sCadena, String sCaracter) {
        int iCantidadValores = 0;
        try {
            String[] arrCadenaObtenida;
            arrCadenaObtenida = sCadena.split(sCaracter, -1);
            iCantidadValores = arrCadenaObtenida.length;
        } catch (Exception e) {
            System.out.println("Error en el metodo RetornarCantidadValoresTrama" + e.getMessage());

        }
        return iCantidadValores;
    }

    public String retornarIdEspecialista(String NombreEspecialista) {
        String idEspecialista = "";
        switch (NombreEspecialista) {
            case "ROGER":
                idEspecialista = "11";
                break;
            case "DIANA":
                idEspecialista = "5";
                break;

            case "BRUNO":
                idEspecialista = "4";
                break;

            case "MIRIAM":
                idEspecialista = "2";
                break;

            case "JOSE":
                idEspecialista = "25";
                break;
            default:
        }
        return idEspecialista;
    }

    //Guarda el reclamo
    public void almacenarNumeroReclamo(String NroReclamo) throws IOException {

        String FILENAMECIEXO = "src/test/resources/ReclamosGenerados/Reclamo_CIEXO.txt";
        String contenido = NroReclamo;
        File file = new File(FILENAMECIEXO);
        // Si el archivo no existe es creado
        if (!file.exists()) file.createNewFile();
        OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);

        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contenido);
        bw.close();

    }

    //Crea archivos y guarda segun la ruta especificada en los Steps
    public void almacenarNroReclamo(String nroReclamo, String ruta) throws IOException {
        String FILENAMECMP = "src/test/resources/ReclamosGenerados/Reclamo_CMP.txt";
        String FILENAMECNR = "src/test/resources/ReclamosGenerados/Reclamo_CNR.txt";
        String FILENAMEANULACION = "src/test/resources/ReclamosGenerados/Solicitud_ANULACION.txt";
        BufferedWriter bw = null;
        OutputStreamWriter fw = null;
        try {
            File file1 = new File(FILENAMECMP);
            File file2 = new File(FILENAMECNR);
            File file3 = new File(FILENAMEANULACION);


            // si el archivo no existe lo va a crear
            if (!file1.exists() && !file2.exists() && !file3.exists()) {
                file1.createNewFile();
                file2.createNewFile();
                file3.createNewFile();

            }
            // true = append file
            //fw = new FileWriter(ruta, true);
            fw = new OutputStreamWriter(new FileOutputStream(ruta, true), StandardCharsets.UTF_8);
            bw = new BufferedWriter(fw);
            bw.write("-" + nroReclamo);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null)
                bw.close();

            if (fw != null)
                fw.close();
        }
    }

    public void almacenarEliminarReclamos(String ruta, String cadena, int indicador) throws IOException {
        String tramanroreclamo = "";
        StringBuilder almacenarcontenido = new StringBuilder();
        int cantidadnroreclamo = 0;
        if (indicador == 0) {
            tramanroreclamo = muestraContenido(ruta);
            if (tramanroreclamo.length() == 0) {
                almacenarcontenido = new StringBuilder(tramanroreclamo + cadena);
            } else {
                almacenarcontenido = new StringBuilder(tramanroreclamo + "-" + cadena);
            }
            almacenarNumeroReclamo(almacenarcontenido.toString());

            //0=añadir, 1=eliminar
        } else if (indicador == 1) {
            tramanroreclamo = muestraContenido(ruta);
            String[] arreglonroreclamo = tramanroreclamo.split("-", -1);
            cantidadnroreclamo = arreglonroreclamo.length;
            if (cantidadnroreclamo == 1) {
                almacenarNumeroReclamo("");
            } else {
                for (int i = 1; i < cantidadnroreclamo; i++) {
                    almacenarcontenido.append("-").append(arreglonroreclamo[i]);
                }
                almacenarNumeroReclamo(almacenarcontenido.substring(1, almacenarcontenido.length()));
            }
        }
    }

    public String muestraContenido(String archivo) throws IOException, RuntimeException {
        File f = new File(archivo);
        BufferedReader entrada = null;
        String linea = "";
        try {

            //entrada = new BufferedReader(new FileReader(f));
            entrada = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8));

            while (entrada.ready()) {
                linea = entrada.readLine();
                //System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert entrada != null;
            entrada.close();
        }
        return linea;
    }

    public String obtenerUsuarioporArea(String CodigoArea) {
        String areacode = "";
        String areadescription = "";
        String usercode = "";
        String username = "";
        String password = "";

        switch (CodigoArea) {
            case "GPR":
                areacode = "000009";
                areadescription = "Gestión De Pedidos Y Reclamos TC";
                usercode = "XT9402";
                username = "Eliana Villafuerte";
                password = "Interbank1812";
                break;

            case "SEG":
                areacode = "000006";
                areadescription = "Dpto|Seguros";
                usercode = "XT9832";
                username = "Angel Santander";
                password = "12345678";
                break;

            case "ECT":
                areacode = "000014";
                areadescription = "EECC TC";
                usercode = "XT8541";
                username = "Walter Huacho";
                password = "12345678";
                break;

            case "CUD":
                areacode = "000015";
                areadescription = "CUSTODIA DE DOCUMENTOS";
                usercode = "XT7667";
                username = "Mariela Alberto";
                password = "12345678";
                break;
            default:
        }
        return areacode + "-" + areadescription + "-" + usercode + "-" + username + "-" + password;
    }

    public String obtenerUsuarioSupervisor(String UsuarioSupervisor) {
        String usercode = "";
        String password = "";

        switch (UsuarioSupervisor) {
            case "GPR":
                usercode = "XT9833";
                password = "32165498";
                break;

            case "SEG":
                usercode = "XT9831";
                password = "32165498";
                break;

            case "ECT":
                usercode = "XT8641";
                password = "32165498";
                break;
            case "CUD":
                usercode = "XT7229";
                password = "32165498";
                break;
            default:
        }
        return usercode + "-" + password;
    }

    public String obtenerAreaDerivacion(String CodArea) {
        String nombrearea = "";

        switch (CodArea) {
            case "SEG":
                nombrearea = "000006";
                break;
            case "ECT":
                nombrearea = "000014";
                break;
            case "CUD":
                nombrearea = "000015";
                break;
            default:
        }
        return nombrearea;
    }

    public String obtenerTextoTipologia(String CodTipologia) {
        String nombretipologia = "";

        switch (CodTipologia) {
            case "1":
                nombretipologia = "Cobros Indebidos";
                break;
            case "2":
                nombretipologia = "Exoneración de Cobros";
                break;
            case "3":
                nombretipologia = "Consumos No Reconocidos Por Fraude";
                break;
            case "4":
                nombretipologia = "Consumos Mal Procesados Por El Comercio/marca";
                break;
            case "5":
                nombretipologia = "Anulación De Tarjeta De Crédito";
                break;
            default:
        }
        return nombretipologia;
    }

    public String obtenerTextoRespuesta(String CodRespuesta) {
        String nombrerespuesta = "";

        switch (CodRespuesta) {
            case "ADDRESS":
                nombrerespuesta = "DIRECCIÓN";
                break;
            case "EMAIL":
                nombrerespuesta = "EMAIL";
                break;
            default:
        }
        return nombrerespuesta;
    }

    public boolean scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true)", element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String completarLongitud(int cantidadlongitud, String valor) {
        for (int i = 0; i < cantidadlongitud; i++) {
            valor = "0" + valor;
            if (valor.length() == 15) {
                break;
            }
        }
        return valor;
    }

    public String obtenerFiltroVencimiento(String filtrovencimiento) {
        String filtro = "";

        switch (filtrovencimiento) {
            case "Nuevo":
                filtro = "div > div:nth-child(1) > label";
                break;

            case "Por Vencer":
                filtro = "div > div:nth-child(2) > label";
                break;

            case "Vencidos del área":
                filtro = "div > div:nth-child(3) > label";
                break;

            case "Vencidos ante el cliente":
                filtro = "div > div:nth-child(4) > label";
                break;
            default:
        }
        return filtro;
    }

    public String obtenerFiltroTipoTramite(String filtrotipotramite) {
        String filtro = "";

        switch (filtrotipotramite) {
            case "Reclamo":
                filtro = "div > div:nth-child(1) > label";
                break;
            case "Pedido":
                filtro = "div > div:nth-child(2) > label";
                break;
            default:
        }
        return filtro;
    }

    public String obtenerFiltroSegmento(String filtrosegmento) {
        String filtro = "";
        switch (filtrosegmento) {
            case "Joven":
                filtro = "div > div:nth-child(1) > label";
                break;
            case "Premium":
                filtro = "div > div:nth-child(2) > label";
                break;
            case "Preferente":
                filtro = "div > div:nth-child(3) > label";
                break;
            case "Emprendedor":
                filtro = "div > div:nth-child(4) > label";
                break;
            case "Empresario":
                filtro = "div > div:nth-child(5) > label";
                break;
            case "Pequeño Empresario":
                filtro = "div > div:nth-child(6) > label";
                break;
            case "Microempresario":
                filtro = "div > div:nth-child(7) > label";
                break;
            case "Persona Natural sin Negocio (PNSN)":
                filtro = "div > div:nth-child(8) > label";
                break;
            case "Informal":
                filtro = "div > div:nth-child(9) > label";
                break;
            case "Select":
                filtro = "div > div:nth-child(10) > label";
                break;
            case "Consumo Inicial":
                filtro = "div > div:nth-child(11) > label";
                break;
            case "Cliente Nuevo":
                filtro = "div > div:nth-child(12) > label";
                break;
            case "No Segmentado":
                filtro = "div > div:nth-child(13) > label";
                break;
            default:
        }
        return filtro;
    }

    public String obtenerFiltroEstado(String filtroestado) {
        String filtro = "";

        switch (filtroestado) {
            case "En proceso":
                filtro = "div > div:nth-child(1) > label";
                break;
            case "Proc. val.":
                filtro = "div > div:nth-child(2) > label";
                break;
            case "No proc. val.":
                filtro = "div > div:nth-child(3) > label";
                break;
            default:
        }
        return filtro;
    }

    public String obtenerFiltroNivelServicio(String filtronivelservicio) {
        String filtro = "";

        switch (filtronivelservicio) {
            case "Platino":
                filtro = "div > div:nth-child(1) > label";
                break;
            case "Oro":
                filtro = "div > div:nth-child(2) > label";
                break;
            case "Plata":
                filtro = "div > div:nth-child(3) > label";
                break;
            case "Bronce":
                filtro = "div > div:nth-child(4) > label";
                break;
            case "Sin Especificar":
                filtro = "div > div:nth-child(5) > label";
                break;
            case "Premium":
                filtro = "div > div:nth-child(6) > label";
                break;
            default:
        }
        return filtro;
    }


    public String obtenerMotivoTarjeta(String motivotarjeta) {
        String motivo = "";

        switch (motivotarjeta) {
            case "Fue robada o usada en un secuestro":
                motivo = "CFS001";
                break;
            case "La perdió o no recuerda":
                motivo = "CFS002";
                break;
            case "Está en poder del cliente":
                motivo = "CFS003";
                break;
            case "El cliente nunca contrató el producto":
                motivo = "CFS004";
                break;
            case "Fue usada a través de las aplicaciones por robo de celular":
                motivo = "CFS005";
                break;
            default:
        }
        return motivo;
    }
}