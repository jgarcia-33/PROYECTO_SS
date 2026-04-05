package hlanz.juegonaves;

import bpc.framework.consola.*;

public class ControladorFinJuego extends GameObject{

    public ControladorFinJuego(){
        super();
    }

    @Override
    public void inicializar() {

    }

    @Override
    public void ejecutarFrame() {
        JuegoNaves juego = (JuegoNaves) this.escena;

        if (juego.getEnemigos().isEmpty()){
            this.juego.detener();
        }
    }

    @Override
    public void finalizar() {

    }
}
