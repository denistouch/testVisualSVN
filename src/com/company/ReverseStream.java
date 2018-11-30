package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReverseStream {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        //send args to
        if (args.length != 0) {
            inputStream = new FileInputStream(args[0]);
            System.out.printf("args[%d] = " + args[0] + "\n", 0);
            outputStream = new FileOutputStream(args[1]);
            System.out.printf("args[%d] = " + args[1] + "\n", 1);
        } else {
            /*inputStream = new FileInputStream("C:\\Users\\denis\\IdeaProjects\\testVisualSVN\\input.dat");
            outputStream = new FileOutputStream("C:\\Users\\denis\\IdeaProjects\\testVisualSVN\\output.dat");*/
            System.exit(0);
        }
        //сделать отдельным классом наследующим Thread и производить операцию в нём
        long[] arrBytes = new long[256];
        long startTime = System.currentTimeMillis();

        int bufferSize = 1024000;
        byte buffer[];
        System.out.println(inputStream.available());
        if (inputStream.available() < bufferSize)
            buffer = new byte[inputStream.available()];
        else
            buffer = new byte[bufferSize];
        //подумать над реализацией записи файлов большого объема
        while (inputStream.available() > 0) {
            if (inputStream.available() < bufferSize)
                bufferSize = inputStream.available();
            inputStream.read(buffer, 0,bufferSize);
            byte tmp[] = buffer;
            for (int i = 0; i <= buffer.length/2; i++) {
                byte temp = buffer[i];
                buffer[i] = buffer[buffer.length - i - 1];
                buffer[buffer.length - i - 1] = temp;
            }
            outputStream.write(buffer, 0, bufferSize);

        }
        long finishTime = System.currentTimeMillis();
        System.out.println("\nвремя работы=" + (finishTime - startTime) + "ms.");
        inputStream.close();
        outputStream.close();
    }
}
