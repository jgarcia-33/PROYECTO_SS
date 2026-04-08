package hlanz.juegonaves;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class CacheImagenes {

    private static CacheImagenes instancia = null;
    private Map<String, Image> imagenes;


    private CacheImagenes() {
        this.imagenes = new HashMap<>();
    }

    public static CacheImagenes getInstancia() {
        if (instancia == null) {
            instancia = new CacheImagenes();
        }
        return instancia;
    }

    public Image getImagen(String nombreImagen) {
        Image salida = null;
        if (this.imagenes.containsKey(nombreImagen)) {
            salida = imagenes.get(nombreImagen);
        }

        if (salida==null) {
            try {
                String rutaCompleta = "/imagenes/" + nombreImagen;
                Image imagenCargada = ImageIO.read(getClass().getResource(rutaCompleta));
                imagenes.put(nombreImagen, imagenCargada);
                salida = imagenCargada;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return salida;
    }
}