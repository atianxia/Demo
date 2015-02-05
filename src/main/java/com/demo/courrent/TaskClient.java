package com.demo.courrent;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class TaskClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        for(int i=0;i<10;i++){
            Socket client = new Socket("localhost", 8080);
            Writer writer = new OutputStreamWriter(client.getOutputStream());
            writer.write("Hello Server."+"----  " + i+ " ----");
            writer.flush();//写完后要记得flush
            writer.close();
            client.close();
        }
    }

}
