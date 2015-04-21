import java.awt.event.KeyEvent;

/**
 * Created by jaime on 21-04-2015.
 */
public class Jugador  implements Constantes{
    public Laberinto laberinto;
    public int i_jugador, j_jugador;

    public Jugador(Laberinto l) {
        laberinto = l;
        i_jugador = 0;
        j_jugador = 0;
        laberinto.casillas[i_jugador][j_jugador].tipo='J';
    }

    public void mover_arriba() {
        System.out.println("Jugador está en: " + i_jugador + ", " + j_jugador);
        if (j_jugador > 0) {
            if (laberinto.casillas[i_jugador][j_jugador-1].tipo != 'O') {
                laberinto.casillas[i_jugador][j_jugador].tipo = 'C';
                j_jugador -= 1;
                laberinto.casillas[i_jugador][j_jugador].tipo = 'J';

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
            if (laberinto.casillas[i_jugador][j_jugador+1].tipo != 'O') {
                laberinto.casillas[i_jugador][j_jugador].tipo = 'C';
                j_jugador += 1;
                laberinto.casillas[i_jugador][j_jugador].tipo = 'J';

            }else{
                System.out.println("Imposible bajar");
            }
        }
    }

    public void mover_izq() {
        System.out.println("Jugador está en: " + i_jugador + ", " + j_jugador);
        if (j_jugador > 0) {
            if (laberinto.casillas[i_jugador-1][j_jugador].tipo != 'O') {
                laberinto.casillas[i_jugador][j_jugador].tipo = 'C';
                i_jugador -= 1;
                laberinto.casillas[i_jugador][j_jugador].tipo = 'J';

            }else{
                System.out.println("Imposible izq");
            }
        }
    }

    public void mover_der() {
        System.out.println("Jugador está en: " + i_jugador + ", " + j_jugador);
        if (j_jugador < heightGameWorld-1) {
            if (laberinto.casillas[i_jugador+1][j_jugador].tipo != 'O') {
                laberinto.casillas[i_jugador][j_jugador].tipo = 'C';
                i_jugador += 1;
                laberinto.casillas[i_jugador][j_jugador].tipo = 'J';

            }else{
                System.out.println("Imposible der");
            }
        }
    }


    
    
}
