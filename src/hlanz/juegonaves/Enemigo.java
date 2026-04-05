package hlanz.juegonaves;

import bpc.framework.consola.*;

import java.awt.*;

public abstract class Enemigo extends SpriteGameObject {
    public Enemigo(int x, int y, Image img){
        super(img, x, y);
    };

    abstract int getPuntuacion();
}

