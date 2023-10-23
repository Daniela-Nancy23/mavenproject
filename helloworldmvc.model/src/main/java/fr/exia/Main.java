package fr.exia;

/**
 * Hello world!
 *
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileReader;
import java.io.FileWriter;


public class Main {
    public static void main(String[] args) {
        // Chemin d'accès au fichier texte
        String filePath = "C:/Users/user/Downloads/HelloWorld";

        try {
            // Lecture du fichier
            Path path = Paths.get(filePath);
            BufferedReader reader = Files.newBufferedReader(path);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            // Écriture dans le fichier
            BufferedWriter writer = Files.newBufferedWriter(path);
            writer.write("Nouveau contenu");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public class DAOHelloWorld implements IModel {
        private static DAOHelloWorld instance = null;
        private final String fileName = "HelloWorld.txt";
        private String helloWorldMessage = null;

        private DAOHelloWorld() {
        }

        public static DAOHelloWorld getInstance() {
            if (instance == null) {
                instance = new DAOHelloWorld();
            }
            return instance;
        }

        public void setInstance(DAOHelloWorld instance) {
            DAOHelloWorld.instance = instance;
        }

        public void readFile() {
            // Code pour lire le fichier et assigner le message à helloWorldMessage
        }

        @Override
        public String getHelloWorld() {
            if (helloWorldMessage == null) {
                readFile();
            }
            return helloWorldMessage;
        }

        public void setHelloWorldMessage(String helloWorldMessage) {
            this.helloWorldMessage = helloWorldMessage;
        }
    }

    public class Model implements IModel {
        @Override
        public String getHelloWorld() {
            return "Hello World!";
        }
    }
