import bpc.daw.consola.Consola;

import java.util.List;

public abstract class Escena implements ElementoJuego{
    protected Juego juego;
    protected Consola consola;
    private List<GameObject> objetos;

    public Escena(){

    }
    protected abstract void añadirObjetosIniciales();
    public void añadir(GameObject obj){

    }
    public void retirar(GameObject obj){

    }
}
