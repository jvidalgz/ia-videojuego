import javax.swing.*;
import java.awt.*;

/**
 * Created by jaime on 14-04-2015.
 */
public class Laberinto extends JComponent implements Constantes {

    //dimensiones del laberinto
    public int ancho,largo;
    //las casillas n x m
    public Celda[][] casillas;

    public Laberinto(){
        casillas = new Celda[heightGameWorld][widthGameWorld];
        for (int i = 0; i < heightGameWorld; i++) {
            for (int j = 0; j < widthGameWorld; j++) {
                casillas[i][j] = new Celda(i + (i * sizeCell), j + (j * sizeCell));
            }
        }

        this.ancho = widthGameWorld * sizeCell;
        this.largo = heightGameWorld * sizeCell;
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < heightGameWorld; i++) {

            for (int j = 0; j < widthGameWorld; j++) {

                casillas[i][j].paintComponent(g);
            }
        }
    }

    @Override
    public void update(Graphics g) {
        for (int i = 0; i<heightGameWorld ; i++) {
            for (int j = 0; j<widthGameWorld ; j++) {
                if (casillas[i][j].seleccionado) {
                    casillas[i][j].update(g);
                    g.setColor(Color.BLUE);
                }
            }
        }
    }


}
