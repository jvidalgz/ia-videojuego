import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    // boolean seleccionado; // estado de la celda
    public char tipo;
    public BufferedImage jugador, obstaculo, camino, adversario;

    //const
    public Celda(int x, int y, char tipo) {
        this.x = x;
        this.y = y;
        //this.altura = x + sizeCell;
        //this.anchura = y + sizeCell;
        //this.seleccionado=false;
        try {
            jugador = ImageIO.read(new File("img/img1.png"));
            obstaculo = ImageIO.read(new File("img/img2.png"));
            camino = ImageIO.read(new File("img/img3.png"));
            adversario = ImageIO.read(new File("img/img4.png"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }


    }

    // metodo para dibujar celda
    /*@Override
    public void paintComponent(Graphics graphics) {
        graphics.drawRect(x, y, sizeCell, sizeCell);
    }*/

    //metodo llamado por repaint
    @Override
    public void update(Graphics g) {
       /* if (seleccionado) {
            g.drawRect(x, y, sizeCell, sizeCell);
            g.fillRect(x, y, sizeCell, sizeCell);
        }else {
            g.drawRect(x, y, sizeCell, sizeCell);
        }*/

        switch (tipo) {
            case 'J': g.drawImage(jugador,x,y,this);break;
            case 'O': g.drawImage(obstaculo,x,y,this);break;
            case 'C': g.drawImage(camino,x,y,this);break;
            case 'A': g.drawImage(adversario,x,y,this);break;
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
