package hlanz.juegonaves;

import bpc.framework.consola.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
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

        this.añadir(new Nave1(KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_W));
        this.añadir(new Nave2(KeyEvent.VK_J, KeyEvent.VK_L, KeyEvent.VK_I));

        for (int i = 0; i < 10; i++) {
            this.añadir(new Enemigo1(Toolkit.getDefaultToolkit().getScreenSize().width*i/10, 100, 5));
        }

        try {
            for (int i = 1; i < 6; i++) {
                this.añadir(new Enemigo2(0, 0, 300*i, 300, 100, 10));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.añadir(new Marcador());
    }

    public static void main(String[] args) {
        Juego j = new Juego();
        JuegoNaves jNaves = new JuegoNaves();
        j.iniciar(jNaves, Resolucion.VENTANA_FULLHD);
    }
}