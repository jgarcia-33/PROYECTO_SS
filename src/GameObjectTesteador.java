public class GameObjectTesteador extends GameObject {
    private boolean inicializado;
    private int frameCounter;

    public GameObjectTesteador(){
        super();
        this.inicializado=false;
        this.frameCounter=0;
    }
    public boolean inicializado(){
        return this.inicializado;
    }
    public int frameCounter(){
        return this.frameCounter;
    }

    @Override
    public void inicializar() {
        this.inicializado=true;
    }

    @Override
    public void ejecutarFrame() {
        this.frameCounter++;
    }

    @Override
    public void finalizar() {
        this.inicializado=false;
    }
}
