import javax.swing.*;
import java.awt.*;

/**
 * Created by jaime on 14-04-2015.
 */
public class Celda  extends JComponent implements Constantes{

    //cordenada x y
    public int x;
    public int y;
    //anchura altura
    public int altura;
    public int anchura;
    boolean seleccionado; // estado de la celda

    //const
    public Celda(int x, int y) {
        this.x = x;
        this.y = y;
        this.altura = x + sizeCell;
        this.anchura = y + sizeCell;
        this.seleccionado=false;

    }

    // metodo para dibujar celda
    /*@Override
    public void paintComponent(Graphics graphics) {
        graphics.drawRect(x, y, sizeCell, sizeCell);
    }*/

    //metodo llamado por repaint
    @Override
    public void update(Graphics g) {
        if (seleccionado) {
            g.drawRect(x, y, sizeCell, sizeCell);
            g.fillRect(x, y, sizeCell, sizeCell);
        }else {
            g.drawRect(x, y, sizeCell, sizeCell);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        //g.drawRect(x, y, sizeCell, sizeCell);
        update(g);
    }//din del metodo paintComponent

    //si el click esta sobre la celda

    public boolean dentro_area(int xp, int yp) {
        Rectangle r = new Rectangle(x, y, sizeCell, sizeCell);
        return r.contains(new Point(xp, yp));
    }

}
