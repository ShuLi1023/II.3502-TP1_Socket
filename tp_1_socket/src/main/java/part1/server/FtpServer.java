package part1.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FtpServer {
    public static void main(String argv[]) throws Exception{
        System.out.println("Server is Running");
        ServerSocket mysocket = new ServerSocket(555);
        while (true){
            Socket connectionSocket = mysocket.accept();
            String filePath = "D:\\Document\\A3_1\\II.3502_Distributed Architectures and Programming\\TP1\\tp_1_socket\\src\\main\\java\\part1\\server\\myfile.txt";
            BufferedInputStream bufferedInputStream = new BufferedInputStream(connectionSocket.getInputStream());
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(filePath));
            byte[] buf=new byte[1024];
            int len=0;
            while((len=bufferedInputStream.read(buf))!=-1){
                bufferedOutputStream.write(buf, 0, len);
            }

            bufferedOutputStream.flush();
            connectionSocket.shutdownInput();
            connectionSocket.close();


        }
    }
}
