package com.bulletinspace.bulletindao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 *
 * @author Johnathan Nava
 */
public class toFile {
    
    public toFile(Collection s) throws IOException {
    save(s);
}

    //method to save String to a text file
    
    public void save(Collection toConvert) throws IOException {
        String path = "C:\\Temp\\";
        PrintWriter outputfile = new PrintWriter(path + "HereIsTheString.txt");
        FileWriter fw = new FileWriter(path + "HereIsTheString.txt", true);
        fw.write(toConvert.toString());
        fw.close();
    }
    
    
}
