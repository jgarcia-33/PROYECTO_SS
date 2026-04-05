package hlanz.juegonaves;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Enemigo1 extends Enemigo{
    private int velocidad;

    public Enemigo1(int x,int y, int v) throws IOException {
        super(x,y, ImageIO.read(new File("imagenes/malo1.png")));
        this.velocidad = v;
    }

    @Override
    int getPuntuacion() {
        return this.velocidad * 2;
    }

    @Override
    public void ejecutarFrame() {
        this.moverX(this.velocidad);

        if (this.getX() > juego.getAnchuraPantalla() || this.getX() < 0){
            this.velocidad = -this.velocidad;
        }
    }
}
