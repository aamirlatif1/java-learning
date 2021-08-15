package edu.learning.sockets;

import java.io.*;
import java.net.Socket;

public class Client1 {
    static class ReadThread extends Thread {
        private InputStream is;
        byte[] buffer = new byte[256];
        ReadThread(InputStream is){
            this.is = is;
        }
        @Override
        public void run() {
            byte[] buffer = new byte[256];
            int readBytes = 0;
            try {
                while(true) {
                    readBytes = is.read(buffer);
                    System.out.println(new String(buffer, 0, readBytes));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static class WriterThread extends Thread{
        private OutputStream os;
        WriterThread(OutputStream os){
            this.os = os;
        }
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            try {
                while (true){
                    String message = reader.readLine();
                    System.out.println("Aamir Says : "+message);
                    os.write(message.getBytes());
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9000);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            os.write("Aamir".getBytes());
            Thread readThread = new ReadThread(is);
            Thread writerThread = new WriterThread(os);
            readThread.start();
            writerThread.start();
//            is.close();
//            os.close();
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
