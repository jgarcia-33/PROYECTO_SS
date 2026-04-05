package bpc.framework.consola;

import java.awt.*;

public class TestResolucion {
    public static void main(String[] args) {
        Dimension[] dimensiones = {
                new Dimension(4096,2160),
                new Dimension(1920,1080),
                new Dimension(2560,1440),
                new Dimension(800,600)

        };
        Resolucion[] resoluciones = {
                Resolucion.VENTANA_4K,
                Resolucion.VENTANA_FULLHD,
                Resolucion.VENTANA_QHD,
                Resolucion.VENTANA_VGA
        };
        for (int i = 0; i < resoluciones.length; i++) {
            System.out.println(resoluciones[i].getResolucion().equals(dimensiones[i]));
        }
    }
}
