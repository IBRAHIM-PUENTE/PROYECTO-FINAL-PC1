package proyectoabyssrúbrica;

public class Jugadores {

    private final String id = "12345678";
    private int score;
    private int intentos;

    public Jugadores(int score, int intentos) {
        this.score = score;
        this.intentos = intentos;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

}
