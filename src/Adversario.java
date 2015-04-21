import java.util.Random;
import java.util.TimerTask;

/**
 * Created by jaime on 21-04-2015.
 */
public class Adversario extends TimerTask implements Constantes {
    public Laberinto laberinto;
    public int i_jugador, j_jugador;

    public Adversario(Laberinto l) {
        laberinto = l;

        i_jugador = heightGameWorld-1;
        j_jugador = numeroAleatorio(0, widthGameWorld - 1);
        laberinto.casillas[i_jugador][j_jugador].tipo = 'A';

    }

    public void mover_izq(){
        if (i_jugador > 0) {
                laberinto.casillas[i_jugador][j_jugador].tipo = 'C';
                i_jugador -= 1;
                laberinto.casillas[i_jugador][j_jugador].tipo = 'A';
            }else{
                laberinto.casillas[i_jugador][j_jugador].tipo = 'C';
                i_jugador = heightGameWorld - 1;
                j_jugador = numeroAleatorio(0, widthGameWorld - 1);
            }
        }

    @Override
    public void run(){
        mover_izq();
        laberinto.lienzo.repaint();
    }

    public int numeroAleatorio(int min, int max) {
        Random random = new Random();
        int numero_aleatorio = random.nextInt((max - min) + 1) + min;
        return numero_aleatorio;
    }

}
