package com.itheima.demo.thinkinjava;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class ServerOneJabber extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerOneJabber(Socket socket) throws IOException {
        this.socket = socket;
        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        start();
    }
    public void run(){
        try {
            while (true){
                String str = in.readLine();
                if("END".equals(str)) break;
                System.out.println("Echoing:"+str);
                out.println(str);
            }
            System.out.println("Closing...");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
public class MultiJabberServer {
    static final int PORT=8080;

    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Server Start");
        try {
            while (true){
                Socket accept = s.accept();
                try {
                    new ServerOneJabber(accept);
                } catch (IOException e) {
                    e.printStackTrace();
                    accept.close();
                }
            }
        } finally {
            s.close();
        }
    }
}
