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

    //const
    public Celda(int x, int y) {
        this.x = x;
        this.y = y;
        this.altura = x + sizeCell;
        this.anchura = y + sizeCell;
    }

    // metodo para dibujar celda
    @Override
    public void paintComponent(Graphics graphics) {
        graphics.drawRect(x, y, sizeCell, sizeCell);
    }

}
