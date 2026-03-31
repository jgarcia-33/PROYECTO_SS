import bpc.daw.consola.Consola;

public class Juego {
    private Consola consola;
    private Escena escena;
    private boolean detener;
    private Resolucion resolucion;

    public void iniciar(Escena e,Resolucion r){
        this.resolucion = r;
        this.consola = new Consola();
    }
    public Escena getEscena(){
        return this.escena;
    }
    public void setEscena(Escena e){
        this.escena = e;
    }
    public void detener(){
        this.detener = true;
    }
    public int getAnchuraPantalla(){
        return this.resolucion.getDimension().width;
    }
    public int getAlturaPantalla(){
        return this.resolucion.getDimension().width;
    }
}
