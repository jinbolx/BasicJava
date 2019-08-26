package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class IOClass {

    public static void main(String[] args) throws IOException {
      // byteToCharStreamTest();
        byteStreamTest();
    }


    public static void byteToCharStreamTest() throws IOException {

        InputStream inputStream = new FileInputStream("C:\\Java\\IO\\a.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream,
                StandardCharsets.UTF_8);
        OutputStream outputStream = new FileOutputStream("C:\\Java\\IO\\b.txt");
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream,
                StandardCharsets.UTF_8);
        char[] b = new char[20];
        int i;
//        int data = inputStreamReader.read();
//        while (data != -1) {
//            System.out.print((char) data);
//            outputStreamWriter.write(data);
//            data = inputStreamReader.read();
//
//        }
        while ((i = inputStreamReader.read(b)) != -1) {
//            System.out.print(new String(b,0,i));
//            System.out.println(" ");
            outputStreamWriter.write(b, 0, i);
        }

        outputStreamWriter.flush();
        outputStreamWriter.close();
        outputStream.close();
        inputStreamReader.close();
        bufferedInputStream.close();
        inputStream.close();
    }
    public static void byteStreamTest() throws IOException {
        InputStream inputStream=new FileInputStream("C:\\Java\\IO\\a.jpg");
        OutputStream outputStream=new FileOutputStream("C:\\Java\\IO\\b.jpg");
        BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
        byte[]bytes=new byte[2048];
//        int i=bufferedInputStream.read();
//        while (i!=-1){
//            bufferedOutputStream.write(i);
//            i=bufferedInputStream.read();
//        }
        int i;
        while ((i=bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,i);
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        outputStream.close();
        bufferedInputStream.close();
        inputStream.close();

    }
}
