package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.util.StringTokenizer;


public class FileReader{
    public Profile getDataFromFile(File file) {
        final String nameKey = "Name:";
        final String emailKey = "Email:";
        final String ageKey = "Age:";
        final String phoneKey = "Phone:";
        String Name = "";
        String Email = "";
        int Age = 0;
        long Phone = 0;
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(line);
                while(tokenizer.hasMoreTokens()){
                    String word = tokenizer.nextToken();
                    switch (word) {
                        case nameKey: Name = tokenizer.nextToken(); break;
                        case emailKey: Email = tokenizer.nextToken(); break;
                        case ageKey: Age = Integer.parseInt(tokenizer.nextToken()); break;
                        case phoneKey: Phone = Long.parseLong(tokenizer.nextToken());
                        default: break;
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new Profile(Name, Age, Email, Phone);
    }
}
