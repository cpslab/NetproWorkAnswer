package part5.part5_Z;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskServerWhile {
    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            ServerSocket server =
                    new ServerSocket(5002);        //ポート番号を指定し、クライアントとの接続の準備を行う
            System.out.println("server is waiting present at 5002");

            Socket socket = server.accept();    //クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("connected");
            ObjectInputStream ois =
                    new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos =
                    new ObjectOutputStream(socket.getOutputStream());

            try {
                while (true) {
                    TaskObj taskObj = (TaskObj) ois.readObject();
                    taskObj.exec();
                    System.out.println(taskObj.getResult());;

                    /* 判定結果をクライアントに送信する */
                    oos.writeObject(taskObj);
                    oos.flush();
                }
            }catch (Exception e) {
                oos.close();
                ois.close();
                socket.close();
                server.close();
                System.exit(0);
            }
        }// エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("エラーが発生したのでプログラムを終了します");
        }
    }
}
