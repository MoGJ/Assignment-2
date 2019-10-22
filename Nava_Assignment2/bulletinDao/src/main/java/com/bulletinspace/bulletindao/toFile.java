package com.bulletinspace.bulletindao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Johnathan Nava
 */
public class toFile {
    private String stringToConvert;
    
    public toFile(String s) throws IOException {
    this.stringToConvert = s;
    save(this.stringToConvert);
    System.out.println(this.stringToConvert);
}

    //method to save String to a text file
    
    public void save(String toConvert) throws IOException {
        String path = "C:\\Temp\\";
        PrintWriter outputfile = new PrintWriter(path + "HereIsTheString.txt");
        FileWriter fw = new FileWriter(path + "HereIsTheString.txt", true);
        fw.write(toConvert);
    }
    
    
    public String getStringToConvert() {
        return stringToConvert;
    }

    public void setStringToConvert(String stringToConvert) {
        this.stringToConvert = stringToConvert;
    }
    
}
