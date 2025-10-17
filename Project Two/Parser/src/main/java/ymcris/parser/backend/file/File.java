package ymcris.parser.backend.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * The File class is the class responsible for have the file's tools to use in
 * the text file input and save file
 *
 * @author YmCris
 * @since Oct 16, 2025
 */
public class File {

    // SPECIFIC METHODS --------------------------------------------------------
    /**
     * Method responsible for verifying whether the file exists.
     *
     * @param filePath - path of the file to be verified.
     * @return - true if it exists.
     */
    public boolean fileExists(String filePath) {
        return new java.io.File(filePath).exists();
    }

    /**
     * Method responsible for verifying whether the file exists.
     *
     * @param filePath - path of the file to be verified.
     * @param fileName - name of the file.
     * @return - true if it exists.
     */
    public boolean fileExists(String filePath, String fileName) {
        return new java.io.File(filePath + java.io.File.separator + fileName + ".txt").exists();
    }

    /**
     * Method responsible for checking if a file is empty.
     *
     * @param filePath - file path.
     * @return - true if it is empty.
     */
    public boolean isEmpty(String filePath) {
        return new java.io.File(filePath).length() == 0;
    }

    /**
     * Method responsible for reading the contents of a text file and saving it
     * in an ArrayList so that it can be displayed by the JFAnalyzer.
     *
     * @param filePath - Path of the file from which the information will be
     * obtained.
     *
     * @return - ArrayList of lines.
     */
    public ArrayList<String> getFileContent(String filePath) {
        String temp;
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new java.io.File(filePath)))) {
            while ((temp = reader.readLine()) != null) {
                lines.add(temp);
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al leer el archivo porque " + e.getMessage());
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Method responsible for creating a text file in a path.
     *
     * @param filePath - file path
     * @param fileName - file name
     * @return file created
     */
    public java.io.File createFile(String filePath, String fileName) {
        java.io.File file = new java.io.File(filePath + java.io.File.separator + fileName + ".txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
        }
        return file;
    }

    /**
     * Method responsible for writing to a text file.
     *
     * @param filePath - path where the text file is located.
     * @param fileName - file name.
     * @param content - content to be added to the text file.
     */
    public void writeInFile(String filePath, String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new java.io.File(filePath + java.io.File.separator + fileName + ".txt")))) {
            writer.write(content);
        } catch (Exception e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al escribir en el archivo porque " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Method responsible for verifying whether a folder exists.
     *
     * @param folderPath
     * @return true if it exists
     */
    public boolean folderExists(String folderPath) {
        return new java.io.File(folderPath).exists();
    }
}
