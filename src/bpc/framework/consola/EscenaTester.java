package bpc.framework.consola;

public class EscenaTester extends Escena {
    private GameObject tester;

    public EscenaTester(GameObject t){
        this.tester=t;
    }

    public GameObject getTester() {
        return this.tester;
    }

    @Override
    protected void añadirObjetosIniciales() {
        añadir(this.tester);
    }
}
