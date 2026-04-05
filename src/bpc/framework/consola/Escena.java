package bpc.framework.consola;

import bpc.daw.consola.Consola;

import java.util.ArrayList;
import java.util.List;

public abstract class Escena implements ElementoJuego {
    protected Juego juego;
    protected Consola consola;
    private List<GameObject> objetos;

    public Escena(){
        this.objetos=new ArrayList<>();
    }
    protected abstract void añadirObjetosIniciales();
    public void añadir(GameObject obj){
        obj.escena=this;
        obj.juego=this.juego;
        obj.consola=this.consola;
        this.objetos.add(obj);
        obj.inicializar();
    }
    public void retirar(GameObject obj){
        obj.finalizar();
        this.objetos.remove(obj);
        obj.juego=null;
        obj.consola=null;
    }
    @Override
    public void inicializar(){
        if (this.consola == null || this.juego == null){
            throw new IllegalStateException("Hay que añadir la escena al juego para poder inicializarla");
        }else{
            this.objetos=new ArrayList<>();
        }

        this.añadirObjetosIniciales();
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
