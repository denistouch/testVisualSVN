package com.company;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream {
    public static void main(String[] args) {
        String string = "Hello world!";
        try (FileOutputStream fileOutputStream =
                     new FileOutputStream("C:\\Users\\denis\\IdeaProjects\\testVisualSVN\\input.dat")) {
            byte[] buffer = string.getBytes();
            //byte[] buffer ={0x0A, 0x00, 0x20, 0xF};
            fileOutputStream.write(buffer, 0, buffer.length);
            for (int i = 0; i < buffer.length; i++) {
                System.out.println((long) buffer[i]);
            }
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The file has been written");
    }
}
