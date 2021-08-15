package edu.learning.streams;

import java.io.*;
import java.net.URL;


public class CopyFile {

    public static void main(String[] args) {
        byte[] buffer = new byte[256];
        InputStream is = null;
        OutputStream os = null;
        try {
            URL url = CopyFile.class.getClassLoader().getResource("Sample.txt");
            is = new FileInputStream(url.getFile());
            String path = url.getPath().substring(0, url.getPath().lastIndexOf("/"));
            os = new FileOutputStream(path + "/Sample-copy.txt");
            int readLength;
            while ((readLength = is.read(buffer)) > 0) {
                os.write(buffer, 0, readLength);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if(os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
