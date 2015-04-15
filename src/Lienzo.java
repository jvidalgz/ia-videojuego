import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by jaime on 14-04-2015.
 */
public class Lienzo extends Canvas implements Constantes {
    Laberinto laberinto;

    public Lienzo() {
        laberinto = new Laberinto();
        //color fondo
        this.setBackground(Color.ORANGE);
        this.setSize(laberinto.ancho, laberinto.largo);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                identificarCelda(evt);
                repaint();
            }
        });
    }


    // llamado la primera vez que se 'pinta'
    @Override
    public void paint(Graphics g) {
        laberinto.paintComponent(g);

    }

    // llamado cuando se 'repinta'
    @Override
    public void update(Graphics g) {
        laberinto.update(g);
    }

    //saber que celda ha sido seleccionada
    private void identificarCelda(MouseEvent evt) {
        for (int i = 0; i < heightGameWorld; i++) {
            for (int j = 0; j < widthGameWorld; j++ ) {
                if(laberinto.casillas[i][j].dentro_area(evt.getX(),evt.getY())){
                    laberinto.casillas[i][j].seleccionado = true;
                }
            }
        }
    }

}
