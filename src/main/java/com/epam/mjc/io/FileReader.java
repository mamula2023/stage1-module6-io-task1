package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.util.StringTokenizer;


public class FileReader{
    public Profile getDataFromFile(File file) {
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
                    if(word.equals("Name:"))
                        Name = tokenizer.nextToken();
                    if(word.equals("Email:"))
                        Email = tokenizer.nextToken();
                    if(word.equals("Age:"))
                        Age = Integer.parseInt(tokenizer.nextToken());
                    if (word.equals("Phone:"))
                        Phone = Long.parseLong(tokenizer.nextToken());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new Profile(Name, Age, Email, Phone);
    }
}
