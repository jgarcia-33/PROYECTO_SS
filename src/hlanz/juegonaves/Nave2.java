package hlanz.juegonaves;

import java.awt.*;

public class Nave2 extends Nave {

    public Nave2(int ti, int tde, int tdi) {
        super(ti, tde, tdi,  3, CacheImagenes.getInstancia().getImagen("nave2.png"));
    }

    @Override
    protected void realizarDisparo() {
        Disparo disparo1 = new Disparo(1,this.getX()+this.getAnchura()/2,this.getY(),-3,-3);
        Disparo disparo2 = new Disparo(1,this.getX()+this.getAnchura()/2,this.getY(),3,-3);

        escena.añadir(disparo1);
        escena.añadir(disparo2);
    }
}
