import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class CacheImagenes {

    private static CacheImagenes instancia = null;
    private Map<String, Image> cache;

    private CacheImagenes() {
        this.cache = new HashMap<>();
    }

    public static CacheImagenes getInstancia() {
        if (instancia == null) {
            instancia = new CacheImagenes();
        }
        return instancia;
    }

    public Image getImagen(String nombreImagen) {
        if (cache.containsKey(nombreImagen)) {
            return cache.get(nombreImagen);
        }

        try {
            String rutaCompleta = "/imagenes/" + nombreImagen;
            Image imagenCargada = ImageIO.read(getClass().getResource(rutaCompleta));
            cache.put(nombreImagen, imagenCargada);
            return imagenCargada;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}