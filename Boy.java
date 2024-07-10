package proyectoabyssrúbrica;

import java.awt.Image;

public class Boy extends ContenidoJuego {

    // atributos del boy
    private int velocityY;
    private int gravity = 1;

    public Boy(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
        this.velocityY = 0;
    }

    // método ya abstracto del padre para el movimiento
    @Override
    public void move() {
        velocityY += gravity;
        setY(getY() + velocityY);
        setY(Math.max(getY(), 0));
    }

    // método para saltar propia de la clase boy
    public void jump() {
        velocityY = -9;
    }
}
