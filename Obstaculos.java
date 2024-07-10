package proyectoabyssrúbrica;

import java.awt.Image;

public class Obstaculos extends ContenidoJuego {

    // atributos de los obstaculos
    private int velocityX = -4;
    private boolean passed = false;

    public Obstaculos(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
    }

    // método ya abstracto del padre para el movimiento
    @Override
    public void move() {
        setX(getX() + velocityX);
    }

    // metodos propios de la clase Obstaculos
    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
