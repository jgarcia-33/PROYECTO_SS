package hlanz.juegonaves;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Enemigo2 extends Enemigo{
    private int centroX;
    private int centroY;
    private int radio;
    private double angulo;
    private double velocidad;

    public Enemigo2(int x, int y, int cx, int cy, int r, double v) throws IOException {
        super(x, y, ImageIO.read(new File("imagenes/malo2.png")));
        this.centroX = cx;
        this.centroY = cy;
        this.radio = r;
        this.velocidad = v;
        this.angulo = 0;
    }

    @Override
    int getPuntuacion() {
        return (int) this.velocidad * 3;
    }

    @Override
    public void ejecutarFrame() {
        this.angulo += this.velocidad;

        if (this.angulo >= 2 * Math.PI){
            this.angulo = 0;
        }

        int x = (int) (this.centroX + this.radio * Math.cos(this.angulo));
        int y = (int) (this.centroY + this.radio * Math.sin(this.angulo));

        this.setX(x);
        this.setY(y);
    }
}
