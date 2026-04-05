import java.awt.*;

public class Disparo extends SpriteGameObject{

    private int idJugador;
    private int vx;
    private int vy;
    private Enemigo ;

    public Disparo(int id, int x, int y, int vx, int vy) {
        super(CacheImagenes.getImagen("disparo.png"),x , y);
        this.idJugador=id;
        this.vx=vx;
        this.vy=vy;
    }

    @Override
    public void ejecutarFrame() {
        this.moverX(this.vx);
        this.moverY(this.vy);
        if (this.getX()<0||this.getY()<0||this.getX()>Toolkit.getDefaultToolkit().getScreenSize().width||this.getY()>Toolkit.getDefaultToolkit().getScreenSize().height){
            escena.retirar(this);
            this.finalizar();
        }
        for (Enemigo e: escena.objetos){
            if (e instanceof Enemigo) {
                //aqui se comprobaria si colisionan o no, pero actualmente no se me ocurre como hacerlo
                /*
                if (colisionan){
                    escena.retirar(e);
                    e.finalizar;
                    escena.retirar(this);
                    this.finalizar();
                }
                */
            }
        }
    }

}