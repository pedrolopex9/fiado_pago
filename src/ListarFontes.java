import java.awt.*;

public class ListarFontes {
    public static void main(String[] args) {
        String[] fontes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String fonte : fontes) {
            System.out.println(fonte);
        }
    }
}
