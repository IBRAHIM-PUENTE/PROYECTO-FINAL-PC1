package proyectoabyssrúbrica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Abyss extends JPanel implements ActionListener, KeyListener {

    private int boardWidth = 360;
    private int boardHeight = 640;
    private Image FondoImg;
    private Image BoyImg;
    private Image ObsSuperiorImg;
    private Image ObsInferiorImg;
    private Juego juego;
    private Timer gameLoop;
    private Timer placePipeTimer;
    private Timer updateTimer;
    private JButton btnRegresar; // Nuevo botón Regresar

    public Abyss() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setFocusable(true);
        addKeyListener(this);

        // Carga de imágenes
        FondoImg = new ImageIcon(getClass().getResource("./BG.png")).getImage();
        BoyImg = new ImageIcon(getClass().getResource("./Fly.png")).getImage();
        ObsSuperiorImg = new ImageIcon(getClass().getResource("./bldg.png")).getImage();
        ObsInferiorImg = new ImageIcon(getClass().getResource("./bldg.png")).getImage();

        // Botón Regresar
        btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cierra el juego y vuelve al menú principal
                closeGame();
            }
        });
        // Posiciona el botón en la esquina inferior derecha
        btnRegresar.setBounds(boardWidth - 100, boardHeight - 50, 90, 30);
        this.setLayout(null); // Usamos layout nulo para posicionamiento absoluto
        this.add(btnRegresar);

        // Iniciar el juego
        juego = new Juego(boardWidth, boardHeight, BoyImg, ObsSuperiorImg, ObsInferiorImg);

        // Temporizador para ubicar nuevos obstáculos
        placePipeTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.placePipes();
            }
        });
        placePipeTimer.start();

        // Temporizador para el bucle del juego
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();

        updateTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint(); // Actualiza la interfaz
            }
        });
        updateTimer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    // MÉTODO DE DIBUJO
    public void draw(Graphics g) {
        g.drawImage(FondoImg, 0, 0, boardWidth, boardHeight, null);
        Boy bird = juego.getBird();
        g.drawImage(bird.getImg(), bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight(), null);

        for (Obstaculos pipe : juego.getObstaculos()) {
            g.drawImage(pipe.getImg(), pipe.getX(), pipe.getY(), pipe.getWidth(), pipe.getHeight(), null);
        }

        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 32));
        if (juego.isGameOver()) {
            g.drawString("Puntuación: " + String.valueOf((int) juego.getScore()), 10, 35);
        } else {
            g.drawString(String.valueOf((int) juego.getScore()), 10, 35);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        juego.move("12345678");
        repaint();
        if (juego.isGameOver()) {
            placePipeTimer.stop();
            gameLoop.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            juego.getBird().jump();
            if (juego.isGameOver()) {
                juego.reset();
                gameLoop.start();
                placePipeTimer.start();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // Método para cerrar el juego y volver al menú principal
    private void closeGame() {
        placePipeTimer.stop();
        gameLoop.stop();
        JFrame mainFrame = AppManager.getInstance().getMainFrame();
        if (mainFrame != null) {
            mainFrame.setVisible(true);
        }
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (currentFrame != null) {
            currentFrame.dispose();
        }
    }
}
