package hlanz.juegonaves;

import java.awt.*;

public class Nave2 extends Nave {

    public Nave2(int ti, int tde, int tdi, int v, Image image) {
        super(ti, tde, tdi,  3, CacheImagenes.getImagen(nave2.png));
    }

    @Override
    protected void realizarDisparo() {
        Disparo disparo1 = new Disparo(0,this.getX(),this.getY(),-3,-3);
        Disparo disparo2 = new Disparo(0,this.getX(),this.getY(),3,-3);

        escena.añadir(disparo1);
        escena.añadir(disparo2);
    }
}
