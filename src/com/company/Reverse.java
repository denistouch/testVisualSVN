package com.company;

import java.io.*;

public class Reverse {

    public static void main(String[] args) {

        FileInputStream fileInputStream = null;
        RandomAccessFile randomAccessFile = null;

        // by default, let's use utf-8
        String characterEncoding = "utf-8";

        // but if you pass an optional 3rd parameter, we use that
        if(args.length==3) {
            characterEncoding = args[2];
        }

        try{

            // input file
            File input = new File(args[0]);
            fileInputStream = new FileInputStream(input);

            // a reader, because it respects character encoding etc
            Reader inputStreamReader = new InputStreamReader(fileInputStream,characterEncoding);

            // an outputfile
            File output = new File(args[1]);

            // and a random access file of the same size as the input, so we can write in reverse order
            randomAccessFile = new RandomAccessFile(output,"rw");
            randomAccessFile.setLength(input.length());

            // a buffer for the chars we want to read
            char[] buff = new char[1];

            // keep track of the current position (we're going backwards, so we start at the end)
            long position = input.length();

            // Reader.read will return -1 when it reached the end.
            while((inputStreamReader.read(buff))>-1) {

                // turn the character into bytes according to the character encoding
                Character c = buff[0];
                String s = c+"";
                byte[] bBuff = s.getBytes(characterEncoding);

                // go to the proper position in the random access file
                position = position-bBuff.length;
                randomAccessFile.seek(position);

                // write one or more bytes for the character
                randomAccessFile.write(bBuff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // clean up
            try {
                fileInputStream.close();
            } catch (Exception e2) {
            }
            try {
                randomAccessFile.close();
            } catch (Exception e2) {
            }
        }


    }


}