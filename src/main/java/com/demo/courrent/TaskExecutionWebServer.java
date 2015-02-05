package com.demo.courrent;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {
    private static final int nThreads = 5;
    private static final Executor exec = Executors.newFixedThreadPool(nThreads);

    public static void main(String[] args) throws IOException {
        ServerSocket s=null;
        try {
            s = new ServerSocket(8080);
            while (true) {
                final Socket connection = s.accept();
                exec.execute(new Runnable() {

                    @Override
                    public void run() {
                        handleRequest(connection);
                    }
                });

            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            if(s != null){
                s.close();
            }
        }
       
    }
    private static void handleRequest(Socket connection){
        System.out.println("-------------------start--------------------");
        try {
            Thread.sleep(1000L);
            InputStream input;
            input = connection.getInputStream();
            byte[] bytes = new byte[1000];
            input.read(bytes);
            System.out.println(new String(bytes));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------end--------------------");
        // request-handling logic here
    }
}
