import java.awt.*;

/**
 * Created by jaime on 14-04-2015.
 */
public class Lienzo extends Canvas {
    Laberinto laberinto;

    public Lienzo() {
        laberinto = new Laberinto();
        //color fondo
        this.setBackground(Color.ORANGE);
        this.setSize(laberinto.ancho, laberinto.largo);
    }

    @Override
    public void paint(Graphics g) {
        laberinto.paintComponent(g);

    }

}
