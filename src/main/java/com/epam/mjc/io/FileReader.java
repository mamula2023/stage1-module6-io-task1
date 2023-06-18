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
        String name = "";
        String email = "";
        int age = 0;
        long phone = 0;
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(line);
                while(tokenizer.hasMoreTokens()){
                    String word = tokenizer.nextToken();
                    switch (word) {
                        case nameKey: name = tokenizer.nextToken(); break;
                        case emailKey: email = tokenizer.nextToken(); break;
                        case ageKey: age = Integer.parseInt(tokenizer.nextToken()); break;
                        case phoneKey: phone = Long.parseLong(tokenizer.nextToken()); break;
                        default:
                            System.out.println("its okay");
                            break;
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new Profile(name, age, email, phone);
    }
}
