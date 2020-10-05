package part1.client;

import java.io.*;
import java.net.Socket;

public class FtpClient {

    public static void main(String argv[]) throws IOException {

        try{
            //1.create client socket
            Socket socketClient = new Socket("localhost", 555);
            //2.get outputstream to send file to server
            String filePatn = "D:\\Document\\A3_1\\II.3502_Distributed Architectures and Programming\\TP1\\tp_1_socket\\src\\main\\java\\part1\\client\\myfile.txt";
            File file = new File(filePatn);
            System.out.println("the length of file: " + file.length() + "kb");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socketClient.getOutputStream());//BufferedOutputStream connect to outputsream
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePatn));//read client file
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(buf)) != -1) {
                bufferedOutputStream.write(buf, 0, len);//write data to BufferedOutputStream
            }
            bufferedOutputStream.flush();
            socketClient.shutdownOutput();
            //3. get inputstream, get server info
            String serverMsg;
            BufferedReader reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            while ((serverMsg = reader.readLine()) != null) {
                System.out.println("server info: " + serverMsg);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
