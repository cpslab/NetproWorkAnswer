package part5.part5_Y;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskServer {
    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            ServerSocket server =
                    new ServerSocket(5002);        //ポート番号を指定し、クライアントとの接続の準備を行う
            System.out.println("server is waiting present at 5002");

            Socket socket = server.accept();    //クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("connected");

            /* 年齢を受信する */
            ObjectInputStream ois =
                    new ObjectInputStream(socket.getInputStream());


            TaskObj taskObj= (TaskObj) ois.readObject();//Integerクラスでキャスト。
            taskObj.exec();

            /* 判定結果をクライアントに送信する */
            ObjectOutputStream oos =
                    new ObjectOutputStream(socket.getOutputStream());

            oos.writeObject(taskObj);
            oos.flush();

            //close処理

            oos.close();
            ois.close();
            //socketの終了。
            socket.close();
            server.close();

        }// エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("エラーが発生したのでプログラムを終了します");
        }
    }
}
