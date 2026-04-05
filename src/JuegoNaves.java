import bpc.framework.consola.*;
import java.util.ArrayList;
import java.util.List;

public class JuegoNaves extends Escena {

    private List<Enemigo> enemigos;

    public JuegoNaves() {
        super();
        this.enemigos = new ArrayList<>();
    }

    public List<Enemigo> getEnemigos() {
        return this.enemigos;
    }

    @Override
    public void añadir(GameObject obj) {
        super.añadir(obj);
        if (obj instanceof Enemigo) {
            this.enemigos.add((Enemigo) obj);
        }
    }

    @Override
    public void retirar(GameObject obj) {
        super.retirar(obj);
        if (obj instanceof Enemigo) {
            this.enemigos.remove((Enemigo) obj);
        }
    }

    @Override
    protected void añadirObjetosIniciales() {
        this.añadir(new ControladorFinJuego());
        this.añadir(new Fondo(2));

        this.añadir(new Nave1(37, 39, 32));
        this.añadir(new Nave2(65, 68, 87));

        this.añadir(new Enemigo1(100, 100, 5));
        this.añadir(new Enemigo1(300, 100, 5));

        this.añadir(new Marcador());
    }

    public static void main(String[] args) {
        Juego j = new Juego();
        j.iniciar(new JuegoNaves(), Resolucion.VENTANA_FULLHD);
    }
}