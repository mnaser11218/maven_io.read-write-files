package com.github.curriculeon;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
//import java.util.Collections;
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

//    @Override
//    public void write(String contentToBeWritten) {
//            try{
//                fileWriter.write(contentToBeWritten);
//               // fileWriter.flush(); // Flushes the stream
//
//                fileWriter.close();
//            }catch(IOException e){
//                throw new RuntimeException(e);
//            }
//
//
//
//    }
public void write(String contentToBeWritten) {
    try (FileWriter fileWriter = new FileWriter(file, true)) {
        fileWriter.write(contentToBeWritten);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}


    @Override
    public void write(Integer lineNumber, String valueToBeWritten) {
        try(FileWriter fileWriter = new FileWriter(file, true)) {

            String[] array= read().split("\n");
            array[lineNumber] = valueToBeWritten;
            String result = String.join("\n", array);
            fileWriter.write(result);

        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }
//@Override
//public void write(Integer lineNumber, String valueToBeWritten) {
//    try (FileWriter fileWriter = new FileWriter(file, false)) { // false for overwriting
//        String[] array = read().split("\n");
//        array[lineNumber] = valueToBeWritten;
//
//        String result = String.join("\n", array);  // Use newline to separate lines
//        fileWriter.write(result);
//
//        System.out.println(this.read());
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    }
//}

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
    public String read() {
        try{
            int i;
            String results = "";
            while ((i = fileReader.read()) != -1) {
                results += (char)i;
            }

            return results;
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void replaceAll(String stringToReplace, String replacementString) {
        String string = this.read().replaceAll(stringToReplace, replacementString);
        write(string);
       // System.out.println(string.toString());
//        for (int i = 0; i < string.size(); i++) {
//
//      String replacedString = string.get(i).replaceAll(stringToReplace, replacementString);
//           // string.set(i,replacedString );
//            if(i == string.size()-1){
//                newString += replacedString;
//            }else{
//                newString += replacedString + "\n";
//
//            }
//        }
       // write(newString);
    }

    @Override
    public void overWrite(String content) {


        try {
            //fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public List<String> toList() {
        return Arrays.asList(read().split("\n"));
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return null;
    }
}
