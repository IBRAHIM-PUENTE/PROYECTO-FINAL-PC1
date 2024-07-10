package proyectoabyssrúbrica;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Juego {

    private int boardWidth;
    private int boardHeight;
    private Boy bird;
    private ArrayList<Obstaculos> pipes;
    private double score;
    private boolean gameOver;
    private Image ObsSuperiorImg;
    private Image ObsInferiorImg;

    public Juego(int boardWidth, int boardHeight, Image boyImg, Image obsSuperiorImg, Image obsInferiorImg) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.bird = new Boy(boardWidth / 8, boardWidth / 2, 34, 24, boyImg);
        this.pipes = new ArrayList<>();
        this.score = 0;
        this.gameOver = false;
        this.ObsSuperiorImg = obsSuperiorImg;
        this.ObsInferiorImg = obsInferiorImg;
    }

    public Boy getBird() {
        return bird;
    }

    public ArrayList<Obstaculos> getObstaculos() {
        return pipes;
    }

    public double getScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }
    
    //MÉTODO DE MOVIMIENTO
    public void move(String playerId) {
        bird.move();
        for (Obstaculos pipe : pipes) {
            pipe.move();
            if (!pipe.isPassed() && bird.getX() > pipe.getX() + pipe.getWidth()) {
                score += 0.5;
                pipe.setPassed(true);
            }
            if (collision(bird, pipe)) {
                gameOver = true;
                saveScore();
                saveScoreToDatabase(playerId);
            }
        }
        if (bird.getY() > boardHeight) {
            gameOver = true;
            saveScore();
            saveScoreToDatabase(playerId);
        }
    }
    
    //MÉTODO DE OBSTACULO
    public void placePipes() {
        Random random = new Random();
        int randomPipeY = (int) (0 - 512 / 4 - Math.random() * (512 / 2));
        int openingSpace = boardHeight / 4;

        Obstaculos topPipe = new Obstaculos(boardWidth, randomPipeY, 64, 512, ObsSuperiorImg);
        pipes.add(topPipe);

        Obstaculos bottomPipe = new Obstaculos(boardWidth, topPipe.getY() + 512 + openingSpace, 64, 512, ObsInferiorImg);
        pipes.add(bottomPipe);
    }
    
    //LÓGICA DE COLISIONES
    private boolean collision(Boy a, Obstaculos b) {
        return a.getX() < b.getX() + b.getWidth()
                && a.getX() + a.getWidth() > b.getX()
                && a.getY() < b.getY() + b.getHeight()
                && a.getY() + a.getHeight() > b.getY();
    }
    
    //CUANDO SE CIERRA LA APLICACIÓN
    public void reset() {
        saveScore();
        bird.setY(boardWidth / 2);
        pipes.clear();
        gameOver = false;
        score = 0;
    }
    
    //MÉTODO PARA GUARDAR LA PUNTUACIÓN
    public void saveScore() {
        try (FileWriter writer = new FileWriter("scores.txt", true)) {
            writer.write("Score: " + score + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //MÉTODO PARA GUARDAR LA PUNTUACIÓN EN LA BASE DE DATOS
    public void saveScoreToDatabase(String playerId) {
        String url = "jdbc:mysql://bxzki9e7m7kx1cocck0c-mysql.services.clever-cloud.com/bxzki9e7m7kx1cocck0c"; // Cambia esta URL según tu configuración
        String user = "uuvkmawpvl2adu8z"; // Cambia esto por tu usuario de la base de datos
        String password = "kW9XSg1sG8DMXN303wMq"; // Cambia esto por tu contraseña de la base de datos

        String selectQuery = "SELECT score, intentos FROM jugadores WHERE id = ?";
        String updateQuery = "UPDATE jugadores SET score = ?, intentos = ? WHERE id = ?";
        

        try (Connection conn = DriverManager.getConnection(url, user, password); PreparedStatement selectStmt = conn.prepareStatement(selectQuery); PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

            selectStmt.setString(1, playerId);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                int currentScore = rs.getInt("score");
                int attempts = rs.getInt("intentos");

                int newScore = (int) score;
                int newAttempts = attempts + 1;

                updateStmt.setInt(1, newScore);
                updateStmt.setInt(2, newAttempts);
                updateStmt.setString(3, playerId);
                updateStmt.executeUpdate();
            } else {
                // Si el jugador no existe en la base de datos, lo insertamos
                String insertQuery = "INSERT INTO jugadores (id, score, intentos) VALUES (?, ?, ?)";
                try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                    insertStmt.setString(1, playerId);
                    insertStmt.setInt(2, (int) score);
                    insertStmt.setInt(3, 1); // El primer intento
                    insertStmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
