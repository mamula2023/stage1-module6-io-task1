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
                    if(word.equals(nameKey))
                        Name = tokenizer.nextToken();
                    if(word.equals(emailKey))
                        Email = tokenizer.nextToken();
                    if(word.equals(ageKey))
                        Age = Integer.parseInt(tokenizer.nextToken());
                    if (word.equals(phoneKey))
                        Phone = Long.parseLong(tokenizer.nextToken());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new Profile(Name, Age, Email, Phone);
    }
}
