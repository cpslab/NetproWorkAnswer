package part5.part5_Y;

import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TaskClient {
    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            BufferedReader reader =        //キーボードから接続するサーバ名を読み込む
                    new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Server name(localhost or 133.27.....)? >");
            String serverName = reader.readLine();
            Socket socket =            //指定されたサーバの5000番ポートに接続を要求する
                    new Socket(serverName, 5002);

            /* キーボードから数字を読み込む */
            System.out.print("数字を入力してください? >");
            int number = 0;
            while(true) {
                try {
                    String lineStr = reader.readLine();
                    number = Integer.parseInt(lineStr);
                    if (number < 2){
                        System.out.println("この数以下に素数はありません");
                        System.out.print("数字を入力してください");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.print("数字を入力してください>");
                }
            }


            TaskObj taskObj= new TaskObj();
            taskObj.setExecNumber(number);

            ObjectOutputStream oos =
                    new ObjectOutputStream(socket.getOutputStream());

            oos.writeObject(taskObj);
            oos.flush();

            /* サーバから判定結果を受信する */
            ObjectInputStream ois =
                    new ObjectInputStream(socket.getInputStream());
            //String result = (String)ois.readObject();//返事を文字列型でキャストする。

            TaskObj resultObj = (TaskObj) ois.readObject();
            int result = resultObj.getResult();
            System.out.println(result);

            oos.close();
            ois.close();

            socket.close();

        }// エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (java.net.UnknownHostException uhe) {
            uhe.printStackTrace();
            System.err.println("送信先のサーバ名が間違っているのでプログラムを終了します");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("エラーが発生したのでプログラムを終了します");
        }
    }
}
