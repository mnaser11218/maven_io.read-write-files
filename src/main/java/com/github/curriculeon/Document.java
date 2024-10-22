package com.github.curriculeon;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author leon on 16/11/2018.
 */
public class Document implements DocumentInterface {

    private final FileWriter fileWriter;
    private final FileReader fileReader;
    private final File file;

    public Document(String fileName) throws IOException {
        this(new File(fileName));
    }

    public Document(File file) throws IOException {
        this.file = file;
        this.fileWriter = new FileWriter(file);
        this.fileReader = new FileReader(file);
    }

    @Override
    public void write(String contentToBeWritten) throws IOException {
        fileWriter.write(contentToBeWritten);
        fileWriter.close();
    }

    @Override
    public void write(Integer lineNumber, String valueToBeWritten) throws IOException {
//        fileWriter.write(lineNumber valueToBeWritten);
       // fileWriter.close();
        /// testing


    }

    @Override
    public String read(Integer lineNumber) throws IOException {
        String line = Files.readAllLines(Paths.get(file.toURI())).get(lineNumber);
        return line;
//        FileInputStream fs= new FileInputStream(file);
//        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
//        for(int i = 0; i < lineNumber-1; i++) {
//
//            br.readLine();
//            String lineIWant = br.readLine();
//            if(i == lineNumber-1){
//                return lineIWant;
//            }
//
//        }
//
//        return null;
    }

    @Override
    public String read() throws IOException {
        int i;
        String results = "";
        while ((i = fileReader.read()) != -1) {
            System.out.print((char)i);
            results += (char)i;
        }
        return results;

    }

    @Override
    public void replaceAll(String stringToReplace, String replacementString) {
    }

    @Override
    public void overWrite(String content) {
    }

    public List<String> toList() {
        return null;
    }

    @Override
    public File getFile() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
