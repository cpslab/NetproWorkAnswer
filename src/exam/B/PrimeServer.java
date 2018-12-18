package exam.B;

import java.io.*;
import java.net.*;

public class PrimeServer {
    private static final int DMAX = 3;

    public static void main(String[] args) {
        try {
            PrimeServer primeserver = new PrimeServer();
            /* 通信用のsocketを作成する */
            int port = 8888;
            ServerSocket srvSocket = new ServerSocket(port);
            System.out.println("サーバを起動しました。IPアドレスは" + srvSocket.getInetAddress() +"です。");
            while (true) {
                Socket socket = srvSocket.accept();

                /* Stringとして受信する場合 */
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                /* Objectとして受信する場合
                    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                    String receivedMessage = (String)ois.readObject();
                */

                /* 送信用 */
                PrintWriter pw = new PrintWriter(socket.getOutputStream());

                String receivedMessage = inputReader.readLine();
                if(receivedMessage.equals("q") || receivedMessage.equals("exit")){
                    System.out.println("終了コマンドを受信しました。サーバを停止します。");
                    pw.close();
                    socket.close();
                    inputReader.close();
                    break;
                }
                try {
                    /*
                       try-catchの中に入れることで、Integer.parseInt()の引数がint以外の場合処理を中断して
                       catch文に飛ぶため、catch内で例外処理をする。
                    */
                    int number = Integer.parseInt(receivedMessage);
                    System.out.println("クライアントから受信した数字: " + receivedMessage);
                    pw.println(primeserver.judgePrime(number));
                    pw.flush();
                    inputReader.close();
                } catch (Exception e) {
                    pw.println("----------入力に誤りがあります----------");
                    pw.flush();
                }
            }
            System.exit(0);

        } catch(IOException e) {
            System.out.println("通信が切断されました");
        }
    }

    /*
       素数を求めるメソッド。詳しくは第5回を振り返ること。
     */
    public String judgePrime(int number){
        String result = "";
        boolean sosu = true;
        if(number < 2){ sosu = false; }
        else {
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    sosu = false;
                    break;
                }
            }
        }

        /*
           課題内ではクライアントに返すメッセージは英語で指示されていますが、
           この回答例では分かりやすくするため、全て日本語にしています。
         */
        if (sosu)
            result = number + "は素数です";
        else
            result = number + "は素数ではありません";

        return result;
    }
}

