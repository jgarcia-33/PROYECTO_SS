package hlanz.juegonaves;

import java.awt.*;
import bpc.framework.consola.*;

public class Disparo extends SpriteGameObject{

    private int idJugador;
    private int vx;
    private int vy;
    private Enemigo enemigo;

    public Disparo(int id, int x, int y, int vx, int vy) {
        super(CacheImagenes.getInstancia().getImagen("disparo.png"), x , y);
        this.idJugador=id;
        this.vx=vx;
        this.vy=vy;
    }

    @Override
    public void finalizar(){
        this.moverY(this.getY()*-2);
        super.finalizar();
    }

    @Override
    public void ejecutarFrame() {
        boolean existe = true;
        this.moverX(this.vx);
        this.moverY(this.vy);
        if (this.getX()<0||this.getY()<0||this.getX()>Toolkit.getDefaultToolkit().getScreenSize().width||this.getY()>Toolkit.getDefaultToolkit().getScreenSize().height){
            this.finalizar();
            existe=false;
        }

        for (GameObject e: this.escena.objetos) {
            if (e instanceof Enemigo enemigo) {
                if (this.sprite.comprobarColision(enemigo.sprite)) {
                    for (GameObject go: this.escena.objetos){
                        if (go instanceof Marcador){
                            ((Marcador) go).incrementarPuntos(this.idJugador,((Enemigo) e).getPuntuacion());
                            this.moverY(Toolkit.getDefaultToolkit().getScreenSize().height);
                        }
                    }
                    this.finalizar();
                    enemigo.finalizar();
                }
            }
        }
    }
}