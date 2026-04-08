package bpc.framework.consola;

import bpc.daw.consola.Consola;

import java.util.ArrayList;
import java.util.List;

public abstract class Escena implements ElementoJuego {
    protected Juego juego;
    protected Consola consola;
    public ArrayList<GameObject> objetos;

    public Escena(){
    }

    @Override
    public void inicializar(){
        if (this.consola == null || this.juego == null){
            throw new IllegalStateException("Hay que añadir la escena al juego para poder inicializarla");
        }else{
            this.objetos=new ArrayList<>();
            this.añadirObjetosIniciales();
        }
    }

    protected abstract void añadirObjetosIniciales();

    public void añadir(GameObject obj){
        obj.juego=this.juego;
        obj.consola=this.consola;
        obj.escena=this;
        obj.inicializar();
        this.objetos.add(obj);
    }
    public void retirar(GameObject obj){
        obj.finalizar();
        this.objetos.remove(obj);
        obj.escena=null;
        obj.consola=null;
    }

    @Override
    public void ejecutarFrame(){
        for (int i = 0; i < this.objetos.size(); i++) {
            this.objetos.get(i).ejecutarFrame();
        }
    }
    @Override
    public void finalizar(){
        while (!this.objetos.isEmpty()){
            this.retirar(this.objetos.get(0));
        }
    }
}
