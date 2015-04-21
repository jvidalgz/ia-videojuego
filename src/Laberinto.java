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

    public Laberinto(){
        casillas = new Celda[heightGameWorld][widthGameWorld];
        for (int i = 0; i < heightGameWorld; i++) {
            for (int j = 0; j < widthGameWorld; j++) {
                casillas[i][j] = new Celda(i + (i * sizeCell), j + (j * sizeCell),'C');
            }
        }

        //indica donde esta el jugador
        i_jugador = 0;
        j_jugador = 6;
        casillas[i_jugador][j_jugador].tipo = 'J';

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

    public void mover_arriba() {
        System.out.println("Jugador está en: " + i_jugador + ", " + j_jugador);
        if (j_jugador > 0) {
            if (casillas[i_jugador][j_jugador-1].tipo != 'O') {
                casillas[i_jugador][j_jugador].tipo = 'C';
                j_jugador -= 1;
                casillas[i_jugador][j_jugador].tipo = 'J';

            }else{
                System.out.println("Contra pared");
            }
        }
            else{
                System.out.println("Imposible subir");
            }

    }

    public void mover_abajo() {
        System.out.println("Jugador está en: " + i_jugador + ", " + j_jugador);
        if (j_jugador <widthGameWorld-1) {
            if (casillas[i_jugador][j_jugador+1].tipo != 'O') {
                casillas[i_jugador][j_jugador].tipo = 'C';
                j_jugador += 1;
                casillas[i_jugador][j_jugador].tipo = 'J';

            }else{
                System.out.println("Imposible bajar");
            }
        }
    }

    public void mover_izq() {
        System.out.println("Jugador está en: " + i_jugador + ", " + j_jugador);
        if (j_jugador > 0) {
            if (casillas[i_jugador-1][j_jugador].tipo != 'O') {
                casillas[i_jugador][j_jugador].tipo = 'C';
                i_jugador -= 1;
                casillas[i_jugador][j_jugador].tipo = 'J';

            }else{
                System.out.println("Imposible izq");
            }
        }
    }

    public void mover_der() {
        System.out.println("Jugador está en: " + i_jugador + ", " + j_jugador);
        if (j_jugador < heightGameWorld-1) {
            if (casillas[i_jugador+1][j_jugador].tipo != 'O') {
                casillas[i_jugador][j_jugador].tipo = 'C';
                i_jugador += 1;
                casillas[i_jugador][j_jugador].tipo = 'J';

            }else{
                System.out.println("Imposible der");
            }
        }
    }

    public void chequearTecla(KeyEvent evento) {
        if (evento.getKeyCode() == 38) {
            System.out.println("mover arri");
            mover_arriba();
        }
        if (evento.getKeyCode() == 40) {
            System.out.println("mover abajo");
            mover_abajo();
        }
        if (evento.getKeyCode() == 37) {
            System.out.println("mover izq");
            mover_izq();
        }
        if (evento.getKeyCode() == 39) {
            System.out.println("mover der");
            mover_der();
        }
    }

}
