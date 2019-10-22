package com.nava_maven_assignment_1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;

/**
 *
 * @author Johnathan Nava
 */
public class People {
    
    
    
    private static String readURL(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }
            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

    }

    public Collection<Person> jsonPull() throws Exception {
        String jsonOrg = readURL("https://www.w3schools.com/angular/customers.php");
        String json = jsonOrg.replace("\"records\":", "");

        System.out.println("json = " + json);

        //Name, City, Country in double quotes, need to remove double quotes
        String json1 = json.replaceFirst("\\{", "");
        String json2 = json1.replace("\"Name\"", "Name");
        String json3 = json2.replace("\"City\"", "City");
        String json4 = json3.replace("\"Country\"", "Country");
        String json5 = json4.substring(0, json4.length()-3);
        
        System.out.println("json = " + json5);

        Gson gson = new Gson();

        java.lang.reflect.Type collectionType = new TypeToken<Collection<Person>>() {
        }.getType();
        Collection<Person> enums = gson.fromJson(json5, collectionType);

        System.out.println("test\n" +
                "----Name" + "\t\t" + "  City" + "\t" + "  Country----");

        for(Person person : enums) {
            System.out.println(person.Name + "\t" + person.City +
                    "\t" + person.Country);
        }
        
        return enums;
    }

    public static void main(String[] args) throws Exception {
        People peoples = new People();
        Collection<Person> persons = peoples.jsonPull();
        
    }
}