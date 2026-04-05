package bpc.framework.consola;

import org.junit.Test;

import static org.junit.Assert.*;

public class JuegoTest {
    @Test
    public void test1(){
        Juego juego = new Juego();
        EscenaTesteadora escenaTesteadora = new EscenaTesteadora();
        Resolucion resolucion = Resolucion.VENTANA_VGA;

        juego.iniciar(escenaTesteadora,resolucion);
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        juego.detener();
        int framesJuego = escenaTesteadora.getTester().frameCounter();
        assertTrue(framesJuego >= 110);
        assertTrue(framesJuego <= 130);
    }

}