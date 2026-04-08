package bpc.framework.consola;

import bpc.daw.consola.Consola;
import bpc.daw.consola.Teclado;

import java.awt.event.KeyEvent;

public class Juego {
    private Consola consola;
    private Escena escena;
    private boolean detener;
    private Resolucion resolucion;

    public Juego(){}
    public void iniciar(Escena e, Resolucion r){
        this.consola = new Consola();
        this.resolucion = r;
        this.setEscena(e);
        this.detener = false;
        Teclado teclado = this.consola.getTeclado();
        while (!this.detener&&!teclado.teclaPulsada(KeyEvent.VK_ESCAPE)){

            this.escena.ejecutarFrame();
            /*
            try{
                //Le pongo 16 milisegundos por que son 1000ms por lo que al ser 60 hago 1000/60 y da 16.66ms y le pongo 16ms que serian los 60 FPS
                Thread.sleep(16);
            }catch (InterruptedException ex){
                throw new RuntimeException(ex.getMessage());
            }
             */
            consola.esperarSiguienteFrame();
        }
        if(!this.detener)
        consola.getCapaTexto().print(0,4,"Juego finalizado, pulsa intro para cerrar");
    }

    public void setEscena(Escena e){
        this.escena = e;
        this.escena.juego=this;
        this.escena.consola=this.consola;
        e.inicializar();
    }
    public Escena getEscena(){
        return this.escena;
    }
    public void detener(){
        this.detener = true;
    }
    public int getAnchuraPantalla(){
        return this.resolucion.getResolucion().width;
    }
    public int getAlturaPantalla(){
        return this.resolucion.getResolucion().height;
    }
}
