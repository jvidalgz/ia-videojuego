import javax.swing.*;
import java.awt.*;

/**
 * Created by jaime on 14-04-2015.
 */
public class VentanaPrincipal extends JFrame implements Constantes {

    public Lienzo lienzo;

    public VentanaPrincipal() {
        lienzo = new Lienzo();
        lienzo.setFocusable(true);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(lienzo);
        this.setSize(lienzo.getWidth(), lienzo.getHeight());
    }
}
