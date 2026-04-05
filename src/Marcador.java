import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class Marcador extends GameObject {

    private int[] puntos;

    public Marcador() {
        this.puntos = new int[2];
    }

    @Override
    public void inicializar() {
        this.puntos[0] = 0;
        this.puntos[1] = 0;
    }

    public void incrementarPuntos(int jugador, int puntosAMarcar) {
        if (puntosAMarcar < 0) {
            throw new IllegalArgumentException("La puntuación no puede ser negativa");
        }
        this.puntos[jugador] += puntosAMarcar;
    }

    @Override
    public void ejecutarFrame() {
        Graphics g = this.consola.getCapaCanvas().getGraphics();
        g.setColor(Color.WHITE);
        g.setFont(new Font("Monospaced", Font.BOLD, 20));

        g.drawString("P1: " + this.puntos[0], 50, 40);
        g.drawString("P2: " + this.puntos[1], 300, 40);
    }

    @Override
    public void finalizar() {
    }
}