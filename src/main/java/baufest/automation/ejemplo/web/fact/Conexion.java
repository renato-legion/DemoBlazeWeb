package baufest.automation.ejemplo.web.fact;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.sql.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Conexion extends PageObject {
    Statement stmt;
    ResultSet rs;
    Connection con;

    Util getConfigProperties = new Util();

/*    public Connection cadenaConexion() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://" + getConfigProperties.getVariableSerenity("db_urlUat")
                    + "database=" + getConfigProperties.getVariableSerenity("db_name")
                    + "user=" + getConfigProperties.getVariableSerenity("db_userUat")
                    + "password=" + getConfigProperties.getVariableSerenity("db_password")
                    + "encrypt=true;"
                    + "trustServerCertificate=false;";

            con = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en createConnection " + e.getMessage());
        }
        return con;
    }*/

    public void cadenaConexion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://" + getConfigProperties.getVariableSerenity("db_urlUat")
                    + "database=" + getConfigProperties.getVariableSerenity("db_name")
                    + "user=" + getConfigProperties.getVariableSerenity("db_userUat")
                    + "password=" + getConfigProperties.getVariableSerenity("db_password")
                    + "encrypt=true;"
                    + "trustServerCertificate=false;";

            con = DriverManager.getConnection(dbUrl);
            System.out.println("Conexión establecida con éxito a la Base de Datos " + con.getMetaData().getDatabaseProductName());
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en createConnection " + e.getMessage());
        }
    }

/*    public String obtenerDatosCreacionReclamo(String nroReclamo) throws SQLException {
        String dataReclamo = null;
        Statement st = cadenaConexion().createStatement();

        String sql = "SELECT claimNumber,originAppCode,favoriteResponseMedium FROM Event.Claim WHERE claimnumber =" + nroReclamo;
        resultSet = st.executeQuery(sql);

        while (resultSet.next()) {
            Data cp = new Data();
            cp.setNroReclamoBd(resultSet.getString("claimNumber"));
            cp.setAppCodeBd(resultSet.getString("originAppCode"));
            cp.setTipoRespuestaBd(resultSet.getString("favoriteResponseMedium"));
            dataReclamo = cp.getNroReclamoBd() + "-" + cp.getAppCodeBd() + "-" + cp.getTipoRespuestaBd();
        }
        cadenaConexion().close();
        return dataReclamo;
    }*/

    public void consultaDatosReclamo(String nroReclamo) {
        try {
            stmt = con.createStatement();
            String sql = "SELECT claimNumber,originAppCode,favoriteResponseMedium FROM Event.Claim WHERE claimnumber =" + nroReclamo;
            rs = stmt.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println("Error en consultaDatosReclamo " + e.getMessage());
        }
    }

    public void verficarDatosReclamo(String reclamo, String rpta) throws SQLException {
        assert rs != null;
        while (rs.next()) {

            String nroreclamobd = rs.getString("claimNumber");
            String originappbd = rs.getString("originAppCode");
            String mediorptabd = rs.getString("favoriteResponseMedium");

            Assert.assertEquals(nroreclamobd, reclamo);
            Assert.assertEquals(originappbd, "girufront");
            Assert.assertEquals(mediorptabd, rpta);
        }
    }

    public void verificarInstanciaReclamo(String nroReclamo) {
        try {
            stmt = con.createStatement();
            String sql2 = "SELECT idInstance FROM Event.ClaimBpm WHERE claimnumber =" + nroReclamo;
            rs = stmt.executeQuery(sql2);

            if (rs.next()) {
                String nroInstancia = rs.getString("idInstance");

                if (!nroInstancia.isEmpty()) {
                    assertTrue("Se creo la instancia con éxito", true);
                } else {
                    fail("No se creo la instancia del reclamo");
                }
                System.out.println("Se creo la instancia " + nroInstancia + " para el reclamo " + nroReclamo);
            }
        } catch (SQLException e) {
            System.out.println("Error en verificarInstanciaReclamo " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Error en verificarInstanciaReclamo " + e.getMessage());
        }
    }
}
