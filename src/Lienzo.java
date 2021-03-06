import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

/**
 * Created by jaime on 14-04-2015.
 */
public class Lienzo extends Canvas implements Constantes {
    Laberinto laberinto;
    public Image fondo;
    public Adversario adv1, adv2;

    public Lienzo() {
        laberinto = new Laberinto(this);
        adv1 = new Adversario(laberinto);
        adv2 = new Adversario(laberinto);

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

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                laberinto.chequearTecla(e);
                repaint();
            }
        });

        Timer lanzadorTareas = new Timer();
        lanzadorTareas.scheduleAtFixedRate(adv1, 0, 120);
        lanzadorTareas.scheduleAtFixedRate(adv2, 0,500);
        //lanzadorTareas.scheduleAtFixedRate(adv1, 0, 750);

    }




    // llamado la primera vez que se 'pinta'
    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo, 0, 0, null);
        laberinto.paintComponent(g);

    }

    // llamado cuando se 'repinta'
    @Override
    public void update(Graphics g) {
        g.drawImage(fondo, 0, 0, null);
        laberinto.update(g);
    }

    //saber que celda ha sido seleccionada
    private void identificarCelda(MouseEvent evt) {
        for (int i = 0; i < heightGameWorld; i++) {
            for (int j = 0; j < widthGameWorld; j++ ) {
                if(laberinto.casillas[i][j].dentro_area(evt.getX(),evt.getY())){
                    if((evt.getModifiers()& InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK){
                        System.out.println("Boton Der - poner obstaculo");
                        laberinto.casillas[i][j].tipo = 'O';
                    }else{
                        System.out.println("Boton izq - poner adversario");
                        laberinto.casillas[i][j].tipo = 'A';
                    }

                }
            }
        }
    }

}
