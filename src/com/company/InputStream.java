package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStream {
    public static void main(String[] args) {
        int size;
        try (FileInputStream fileInputStream =
                     new FileInputStream("C:\\Users\\denis\\IdeaProjects\\testVisualSVN\\input.dat")) {
            /*System.out.println(fileInputStream.toString());
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);*/
            System.out.println("fileInputStream.available()):" + fileInputStream.available());
            int i = -1;
            while ((i = fileInputStream.read()) != -1) {
                System.out.println((long) i);
            }
            fileInputStream.close();
        } catch (IOException e) {

        }
    }
}
