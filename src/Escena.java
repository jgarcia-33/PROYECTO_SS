import bpc.daw.consola.Consola;

import java.util.ArrayList;
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
    @Override
    public void inicializar(){
        if (this.consola == null || this.juego == null){
            throw new IllegalStateException("Hay que añadir la escena al juego para poder inicializarla");
        }
        this.objetos = new ArrayList<>();
        this.añadirObjetosIniciales();
    }
    @Override
    public void ejecutarFrame(){

    }
    @Override
    public void finalizar(){

    }
}
