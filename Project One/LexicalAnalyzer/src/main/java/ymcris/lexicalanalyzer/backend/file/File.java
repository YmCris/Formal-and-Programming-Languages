package ymcris.lexicalanalyzer.backend.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * The File class is the class responsible for watch the input file
 *
 * @author YmCris
 * @since Sep 27, 2025
 */
public class File {
    
     // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de verificar si existe el archivo.
     *
     * @param filePath - ruta del archivo a verificar.
     * @return - true si existe.
     */
    public boolean fileExists(String filePath) {
        return new java.io.File(filePath).exists();
    }

    
    /**
     * Método encargado de verificar si existe el archivo.
     *
     * @param rutaArchivo - ruta del archivo a verificar.
     * @param nombreArchivo - nombre del archivo
     * @return - true si existe.
     */
    public boolean existeArchivo(String rutaArchivo, String nombreArchivo) {
        return new java.io.File(rutaArchivo + java.io.File.separator + nombreArchivo + ".txt").exists();
    }

    /**
     * Método encargado de verificar si un archivo esta vacio.
     *
     * @param filePath - ruta del archivo.
     * @return - true si está vacio.
     */
    public boolean isEmpty(String filePath) {
        return new java.io.File(filePath).length() == 0;
    }

    /**
     * Método encaragado de leer el contenido de un archivo de texto y guardarlo
     * en un arrayList para poder ser mostrado por el JFAnalizador.
     *
     * @param rutaArchivo - Ruta del archivo del cual se obtendrá la
     * información.
     * @return - ArrayList de lineas.
     */
    public ArrayList<String> obtenerContenidoDelArchivo(String rutaArchivo) {
        String temp;
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new java.io.File(rutaArchivo)))) {
            while ((temp = reader.readLine()) != null) {
                lineas.add(temp);
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al leer el archivo porque " + e.getMessage());
            e.printStackTrace();
        }
        return lineas;
    }

    /**
     * Método encargado de crear un archivo de texto en una ruta.
     *
     * @param rutaArchivo - ruta del archivo
     * @param nombreArchivo - nombre del archivo
     * @return archivo creado
     */
    public java.io.File crearArchivo(String rutaArchivo, String nombreArchivo) {
        java.io.File file = new java.io.File(rutaArchivo + java.io.File.separator + nombreArchivo + ".txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
        }
        return file;
    }

    /**
     * Método encargado de escribir en un archivo de texto
     *
     * @param rutaArchivo - ruta donde se encuentra el archivo de texto.
     * @param nombreArchivo - nombre del archivo
     * @param contenido - contenido que se le agregará al archivo de texto.
     */
    public void escribirEnArchivo(String rutaArchivo, String nombreArchivo, String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new java.io.File(rutaArchivo + java.io.File.separator + nombreArchivo + ".txt")))) {
            writer.write(contenido);
        } catch (Exception e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al realizar ____ porque " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método encargado de verificar si existe una carpeta
     *
     * @param rutaCarpeta
     * @return true si existe
     */
    public boolean existeCarpeta(String rutaCarpeta) {
        return new java.io.File(rutaCarpeta).exists();
    }
}
