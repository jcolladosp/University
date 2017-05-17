package aplicaciones.letras;

import librerias.estructurasDeDatos.deDispersion.TablaHash;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import java.net.URL;
import java.net.URLConnection;
/**
 * Estudio de las funciones de dispersion propuestas sobre imagenes
 * 
 * @author (EDA) 
 * @version (Febrero 2016)
 */
public class EvaluaFuncionDispersion {
    public final static int NUM_IMGS = 22000;
	public final static String NOM_DIR = "aplicaciones" + File.separatorChar
        + "letras" + File.separatorChar + "res";
    public final static String NOM_FICH = NOM_DIR + File.separatorChar + "histo"; 
    public final static String EXT = ".txt";
  
    public static void main(String[] args) {
		int fdis = 0;
        try {
            File dir = new File(NOM_DIR); dir.mkdir();
             for (; fdis < 4; fdis++){
                TablaHash<Imagen, String> imagenes = cargarImagenes(fdis);
                System.out.println("Factor de carga:" + imagenes.factorCarga());
                System.out.println("Desviación típica:" + imagenes.desviacionTipica());
                PrintWriter pw = new PrintWriter(new File(NOM_FICH + Imagen.NOMFDIS[fdis] + EXT));
                pw.print(imagenes.histograma());
                pw.flush();
                pw.close();
            }
			
        } catch (FileNotFoundException e) { 
            System.err.println("Problemas con el fichero..." 
                + NOM_FICH + fdis + EXT); 
        } catch (IOException e) {
            System.err.println("No se encontro el fichero: " + Imagen.NOM_URL);
        }
    }
   
    private static TablaHash<Imagen, String> cargarImagenes(int fdis) 
        throws IOException {
        TablaHash<Imagen, String> tab;
        tab = new TablaHash<Imagen, String>(NUM_IMGS);
        URL url = new URL(Imagen.NOM_URL);
        URLConnection con = url.openConnection();
        DataInputStream is = new DataInputStream(con.getInputStream());
        for (int i = 0; i < NUM_IMGS; i++) {
            Imagen img = new Imagen(is, 11, 13, fdis);
            char letra = (char) is.readUnsignedByte();
            int estilo = is.readUnsignedByte();
            int color = is.readUnsignedByte();
            tab.insertar(img, "");
        }
        return tab;
    }
   
}