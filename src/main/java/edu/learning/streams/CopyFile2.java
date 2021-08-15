package edu.learning.streams;

import java.io.*;
import java.net.URL;


public class CopyFile2 {

    public static void main(String[] args) {
        byte[] buffer = new byte[256];
        URL url = CopyFile2.class.getClassLoader().getResource("Sample.txt");
        String path = url.getPath().substring(0, url.getPath().lastIndexOf("/"));
        try ( InputStream is = new FileInputStream(url.getFile());
              OutputStream os = new FileOutputStream(path + "/Sample-copy.txt")){
            int readLength;
            while ((readLength = is.read(buffer)) > 0) {
                os.write(buffer, 0, readLength);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
