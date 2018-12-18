package exam.B;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PrimeClient {
    /*
        クライアントもサーバも、送受信する際の型はStringとObjectのどちらでも実装可能です。
        それぞれの実装例を①と②として示しています。
        尚、この回答例では①の方法(Stringのメッセージを送受信する方法)で実装しています。
    */

    public static void main(String[] args) {
        try {
            /* 通信用のsocketを作成する */
            InetSocketAddress socketAddress = new InetSocketAddress("localhost", 8888);
            System.out.println("サーバに接続しました");
            while(true) {
                Socket socket = new Socket();
                socket.connect(socketAddress, 10000);


                /* サーバからの受信用 */
                BufferedReader receiveReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                /* コンソールから入力した文字列の読み込み */
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

                /* ①コンソールで読み取った文字列をStringとして送信する場合の例 */
                /*
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                pw.println(reader.readLine());
                pw.flush();
                */

                /* ②コンソールで読み取った文字列をObjectとして送信する場合の例 */
                /*
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(reader.readLine());
                oos.flush();
                */

                /* ①の方法で実装 */
                /* 送信用 */
                PrintWriter pw = new PrintWriter(socket.getOutputStream());

                System.out.print("数字を入力してください > ");
                String sendMessage= consoleReader.readLine();

                if(sendMessage.equals("q") || sendMessage.equals("exit")){
                    pw.println(sendMessage);
                    pw.flush();
                    pw.close();
                    socket.close();
                    consoleReader.close();
                    break;
                }

                pw.println(sendMessage);
                pw.flush();

                String receivedMessage = receiveReader.readLine();
                System.out.println(receivedMessage);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
