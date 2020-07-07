package by.sanko.stringproject.reader;

import by.sanko.stringproject.exception.ProjectException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextReader {
    private static final String DEFAULT_PATH = "input/data.txt";

    public String readFromFile(String filename) throws ProjectException {
        String path;
        String inputData;

        if(filename != null && Files.exists(Paths.get(filename))) {
            path = filename;
        } else{
          path = DEFAULT_PATH;
        }

        try{
            inputData = Files.readString(Paths.get(path));
        } catch (IOException e) {
            throw new ProjectException();
        }
        return inputData;
    }

    public String readFromConsole () throws ProjectException {
        StringBuilder stringBuilder = new StringBuilder();
        String stopMSG = "STOP INPUT THE DATA";

        System.out.println("If you want to stop input the data, write ");
        System.out.println(stopMSG);
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputLine = reader.readLine();

            while(!inputLine.equals(stopMSG)){
                stringBuilder.append(inputLine).append(" ");
                inputLine = reader.readLine();
            }

        } catch (IOException e){
            throw new ProjectException();
        }
        return stringBuilder.toString();
    }


}
