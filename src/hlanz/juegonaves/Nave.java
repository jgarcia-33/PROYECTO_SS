package hlanz.juegonaves;

import java.awt.*;
import java.time.Instant;
import bpc.daw.consola.*;
import bpc.framework.consola.SpriteGameObject;


public abstract class Nave extends SpriteGameObject {
    private int teclaIzquierda;
    private int teclaDerecha;
    private int teclaDisparo;
    private int velocidad;
    private Instant ultimoDisparoRealizado;

    public Nave (int ti, int tde, int tdi, int v, Image image){
        super(image,Toolkit.getDefaultToolkit().getScreenSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height*3/4);
        this.teclaIzquierda=ti;
        this.teclaDerecha=tde;
        this.teclaDisparo=tdi;
        this.velocidad=v;
        this.ultimoDisparoRealizado=Instant.now().minusSeconds(1);
    }

    @Override
    public void ejecutarFrame() {
        if (consola.getTeclado().teclaPulsada(this.teclaIzquierda)&&this.getX()>0){
            this.moverX(this.velocidad*-1);
        }
        if (consola.getTeclado().teclaPulsada(this.teclaDerecha)&&this.getX()<Toolkit.getDefaultToolkit().getScreenSize().width-this.getAnchura()){
            this.moverX(this.velocidad);
        }
        if (consola.getTeclado().teclaPulsada(this.teclaDisparo)){
            this.disparar();
        }
    }

    public void disparar(){
        if (Instant.now().minusSeconds(1).isAfter(this.ultimoDisparoRealizado)){
            this.ultimoDisparoRealizado=Instant.now();
            this.realizarDisparo();
        }
    }
    protected abstract void realizarDisparo();
}
