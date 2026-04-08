package hlanz.juegonaves;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Enemigo2 extends Enemigo{
    private int centroX;
    private int centroY;
    private int radio;
    private double angulo;
    private double velocidad;

    public Enemigo2(int x, int y, int cx, int cy, int r, double v) throws IOException {
        super(x, y, CacheImagenes.getInstancia().getImagen("malo2.png"));
        this.centroX = cx;
        this.centroY = cy;
        this.radio = r;
        this.velocidad = v;
        this.angulo = 0;
    }

    @Override
    public void ejecutarFrame() {
        this.angulo += Math.toRadians(this.velocidad);

        if (this.angulo >= 2 * Math.PI){
            this.angulo = 0;
        }

        int xTemp = (int) (this.centroX + this.radio * Math.cos(this.angulo));
        int yTemp = (int) (this.centroY + this.radio * Math.sin(this.angulo));

        this.setX(xTemp);
        this.setY(yTemp);
    }

    @Override
    int getPuntuacion() {
        return (int) this.velocidad * 3;
    }

    @Override
    public void finalizar(){
        this.centroY = Toolkit.getDefaultToolkit().getScreenSize().width+this.centroY;
        super.finalizar();
        if (this.juego.getEscena() instanceof JuegoNaves jn){
            jn.getEnemigos().remove(this);
        }
    }
}
