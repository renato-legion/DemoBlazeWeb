package baufest.automation.ejemplo.util;

//import org.springframework.core.io.ClassPathResource;


public class Util {

    public static String getTemplate(String templatePath) {
        /*try {
            return IOUtils.toString(new ClassPathResource(templatePath).getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        return "hola";
    }
}
