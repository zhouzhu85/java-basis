package com.socket.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Client1 {
    public static void main(String[] args) throws IOException{
        Socket client=new Socket("127.0.0.1",20006);
        client.setSoTimeout(10000);
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        PrintStream out=new PrintStream(client.getOutputStream());
        BufferedReader buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
        boolean flag=true;
        while (flag){
            System.out.print("输入信息：");
            String str=input.readLine();
            out.println(str);
            if ("bye".equals(str)){
                flag=false;
            }else {
                try {
                    String echo=buf.readLine();
                    System.out.println(echo);
                } catch (SocketTimeoutException e) {
                    System.out.println("Time out,No response");
                }
            }
        }
        input.close();
        if (client!=null){
            client.close();
        }
    }
}
