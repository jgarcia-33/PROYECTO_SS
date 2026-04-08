package hlanz.juegonaves;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Enemigo1 extends Enemigo{
    private int velocidad;

    public Enemigo1(int x,int y, int v){
        super(x,y, CacheImagenes.getInstancia().getImagen("malo1.png"));
        this.velocidad = v;
    }

    @Override
    public void ejecutarFrame() {
        this.moverX(this.velocidad);
        if (this.getX()+this.getAnchura() > juego.getAnchuraPantalla() || this.getX() < 0){
            this.velocidad = -this.velocidad;
        }
    }

    @Override
    int getPuntuacion() {
        if (this.velocidad<0){
            this.velocidad*=-1;
        }
        return this.velocidad * 2;
    }
    @Override
    public void finalizar(){
        this.moverY(Toolkit.getDefaultToolkit().getScreenSize().height);
        super.finalizar();
        if (this.juego.getEscena() instanceof JuegoNaves jn){
            jn.getEnemigos().remove(this);
        }
    }
}
