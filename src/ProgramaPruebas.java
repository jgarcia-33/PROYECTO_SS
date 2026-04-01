import java.awt.*;

public class ProgramaPruebas {
    public static void main(String[] args) {
        Image imagen = Toolkit.getDefaultToolkit().getImage("imagen1.png");
        SpriteGameObjectTesteador testeador = new SpriteGameObjectTesteador(imagen,100,100);
        EscenaTester escenaTester = new EscenaTester(testeador);
        Juego juego = escenaTester.juego;
        juego.iniciar(escenaTester,Resolucion.PANTALLA_COMPLETA);
    }
}
