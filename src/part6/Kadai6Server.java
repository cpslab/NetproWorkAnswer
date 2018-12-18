package part6;

import java.io.IOException;
import java.net.*;

public class Kadai6Server {
    private static final int DMAX = 3;

    public static void main(String[] args) {

        while (true) {

            String receivedmessage="";
            String ansmessage="";
            InetAddress replayaddress=null;
            try {
                replayaddress = InetAddress.getLocalHost();
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            }
            try {

                int serverPort = 5000;
                System.out.println("UDP server is waiting at " + serverPort);
                DatagramSocket socket = new DatagramSocket(serverPort);
                DatagramPacket receivePacket = new DatagramPacket(
                        new byte[DMAX], DMAX);

                socket.receive(receivePacket);
                replayaddress=receivePacket.getAddress();

                receivedmessage=new String(receivePacket.getData());
                System.out.println("Receiced Packet Message is "
                        +receivedmessage );
                socket.close();

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }//try end

            ansmessage=convetMessage(receivedmessage);

            try {
                //String servhostname="localhost";
                //String servhostname="133.14.44.133";//ここに隣の人のアドレスを入れる。

                //InetAddress serverAddress = InetAddress.getByName(servhostname);

                byte[] bytesToSend = ansmessage.getBytes();

                System.out.println("sending replay msg from server is "+ansmessage);
                //int serverPort = Integer.parseInt(portnumstr);
                int serverPort = 5001;
                DatagramSocket socket = new DatagramSocket();
                DatagramPacket sendPacket = new DatagramPacket(bytesToSend, bytesToSend.length, replayaddress, serverPort);
                socket.send(sendPacket);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                socket.send(sendPacket);

                socket.close();

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }//try catch end


        }//while
    }//main

    private static String convetMessage(String receivedmessage) {
        StringBuffer sb = new StringBuffer(receivedmessage);
        String ansStr = sb.toString().toUpperCase();
        return "返事は："+ansStr;
    }
}
