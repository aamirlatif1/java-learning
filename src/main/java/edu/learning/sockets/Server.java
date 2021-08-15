package edu.learning.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {

    private static Map<String, OutputStream> clientStream = new HashMap<>();

    static class ClientConnection extends Thread{
        private String name;
        private Socket socket;
        private InputStream is;

        ClientConnection(Socket socket){
            this.socket = socket;
            try {
                this.is = socket.getInputStream();
                String name = readMessage();
                this.name = name;
                System.out.println(name+" is connected with server");
                clientStream.put(name, socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = readMessage();

                    for (Map.Entry<String, OutputStream> entry : clientStream.entrySet()){
                        String name = entry.getKey();
                        OutputStream stream = entry.getValue();
                        if(!name.equals(this.name)) {
                            message = this.name + " says : " + message;
                            stream.write(message.getBytes());
                        }
                    }
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }

        private String readMessage() throws IOException {
            byte[] buffer = new byte[256];
            int readBytes = is.read(buffer);
            return new String(buffer, 0, readBytes);
        }
    }
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            while (true) {
                Socket socket = serverSocket.accept();
                ClientConnection client = new ClientConnection(socket);
                client.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
