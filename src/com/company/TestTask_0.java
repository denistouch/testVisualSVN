package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

public class TestTask_0 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = null;
        RandomAccessFile randomAccessFile = null;
        //send args to
        try {
            if (args.length != 0) {
                System.out.printf("args[%d] = " + args[0] + "\n", 0);
                System.out.printf("args[%d] = " + args[1] + "\n", 1);
            }
            File input = new
                    //File("C:\\Users\\denis\\IdeaProjects\\testVisualSVN\\input_reverse.dat");
                    File(args[0]);
            inputStream = new FileInputStream(input);

            File output = new
                    //File("C:\\Users\\denis\\IdeaProjects\\testVisualSVN\\input_duo_reverse.dat");
                    File(args[1]);
            randomAccessFile = new RandomAccessFile(output, "rw");

            long[] arrBytes = new long[256];
            long startTime = System.currentTimeMillis();
            int bufferSize = 1024000;

            while (inputStream.available() > 0) {
                byte buffer[];

                if (inputStream.available() < bufferSize)
                    bufferSize = inputStream.available();
                buffer = new byte[bufferSize];
                inputStream.read(buffer, 0, bufferSize);
                for (int i = 0; i < buffer.length / 2; i++) {
                    byte temp = buffer[i];
                    buffer[i] = buffer[buffer.length - i - 1];
                    buffer[buffer.length - i - 1] = temp;
                }
                System.out.println("bufferSize: " + bufferSize);
                System.out.println("inputStream.available(): " + inputStream.available());
                randomAccessFile.seek(inputStream.available());
                randomAccessFile.write(buffer);
            }
            long finishTime = System.currentTimeMillis();
            System.out.println("\nвремя работы=" + (finishTime - startTime) + "ms.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
            try {
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }
    }
}
 