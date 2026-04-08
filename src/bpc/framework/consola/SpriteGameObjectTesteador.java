package bpc.framework.consola;

import bpc.daw.consola.Sprite;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SpriteGameObjectTesteador extends GameObject {
    private Sprite sprite;

    public SpriteGameObjectTesteador(Image imagen, int x, int y){
        this.sprite = consola.getCapaSprites().crearSprite(imagen,null,x, y);
    }


    @Override
    public void inicializar() {

    }

    @Override
    public void ejecutarFrame() {
        if (consola.getTeclado().teclaPulsada(KeyEvent.VK_LEFT)){
            sprite.moverX(-20);
        }
        if (consola.getTeclado().teclaPulsada(KeyEvent.VK_RIGHT)){
            sprite.moverX(20);
        }
        if (consola.getTeclado().teclaPulsada(KeyEvent.VK_UP)){
            sprite.moverY(20);
        }
        if (consola.getTeclado().teclaPulsada(KeyEvent.VK_DOWN)){
            sprite.moverY(20);
        }
    }

    @Override
    public void finalizar() {
        consola.getCapaSprites().eliminarSprite(this.sprite);
    }
}
