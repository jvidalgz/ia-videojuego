import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by jaime on 14-04-2015.
 */
public class Laberinto extends JComponent implements Constantes {

    //dimensiones del laberinto
    public int ancho,largo;
    //las casillas n x m
    public Celda[][] casillas;
    public int i_jugador, j_jugador;
    public Jugador jugador;
    public Lienzo lienzo;

    public Laberinto(Lienzo l) {
        lienzo = l;

        casillas = new Celda[heightGameWorld][widthGameWorld];
        for (int i = 0; i < heightGameWorld; i++) {
            for (int j = 0; j < widthGameWorld; j++) {
                casillas[i][j] = new Celda(i + (i * sizeCell), j + (j * sizeCell), 'C');
            }
        }

        //indica donde esta el jugador
        /*i_jugador = 0;
        j_jugador = 6;
        casillas[i_jugador][j_jugador].tipo = 'J';*/
        jugador = new Jugador(this);

        this.ancho = widthGameWorld * sizeCell;
        this.largo = heightGameWorld * sizeCell;
        this.setSize(ancho, largo);
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
                    casillas[i][j].update(g);
                    //g.setColor(Color.BLUE);

            }
        }
    }

    public void chequearTecla(KeyEvent evento) {
        if (evento.getKeyCode() == 38) {
            System.out.println("mover arri");
            jugador.mover_arriba();
        }
        if (evento.getKeyCode() == 40) {
            System.out.println("mover abajo");
            jugador.mover_abajo();
        }
        if (evento.getKeyCode() == 37) {
            System.out.println("mover izq");
            jugador.mover_izq();
        }
        if (evento.getKeyCode() == 39) {
            System.out.println("mover der");
            jugador.mover_der();
        }
    }

}
