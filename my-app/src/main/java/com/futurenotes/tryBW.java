package com.futurenotes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class tryBW {

    //BufferedReader + FileReader: Best for reading text files line-by-line
    //FileInputStream: Best for binary files (e.g., images, audio files)
    //RandomAccessFile: Best for read/write specific portions of a large file


    public static void main(String[] args) {

         String filePath = "/Users/jaiden/Documents/testFile.txt";
        // String filePath = "//Users//jaiden//Documents//testFile.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));) {
            // System.out.println("That file exists");
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("Could not locate file");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }



        // String[] names = {"John", "Carl", "Jerry"};
        // try {
        //     BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        //     writer.write("Writing to a file.");
        //     writer.write("\nHere's another line.");

        //     for (String name : names) {
        //         writer.write("\n" + name);
        //     }
        //     writer.close();
        // } catch (IOException e) {
        //     // TODO: handle exception
        //     e.printStackTrace();
        // }



    //     try {
    //         BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
    //         String line;
    //         while((line = reader.readLine()) != null) {
    //             System.out.println(line);
    //         }
    //         // System.out.println(reader.readLine());
    //         reader.close();
            
    //     } catch (IOException e) {
    //         // TODO: handle exception
    //         e.printStackTrace();
    //     }



    }
    
}
