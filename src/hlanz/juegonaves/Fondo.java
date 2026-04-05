package hlanz.juegonaves;

import bpc.framework.consola.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Fondo extends GameObject {

    private Image imagen;
    private Rectangle camara;
    private int velocidadCamara;

    public Fondo(int vc) {
        this.velocidadCamara = vc;
    }

    @Override
    public void inicializar() {
        this.imagen = CacheImagenes.getInstancia().getImagen("fondo.png");
        int ancho = this.juego.getAnchuraPantalla();
        int alto = this.juego.getAlturaPantalla();
        this.camara = new Rectangle(0, 0, ancho, alto);
    }

    @Override
    public void ejecutarFrame() {
        Graphics g = this.consola.getCapaCanvas().getGraphics();
        g.drawImage(this.imagen, 0, 0, camara.width, camara.height,
                camara.x, camara.y, camara.x + camara.width, camara.y + camara.height, null);

        this.camara.y += this.velocidadCamara;

        if (this.camara.y + this.camara.height > this.imagen.getHeight(null)) {
            this.camara.y = 0;
        }
    }

    @Override
    public void finalizar() {
    }
}