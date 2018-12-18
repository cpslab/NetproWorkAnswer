package part5.part5_A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Kadai5AClient {
    public static void main(String arg[]){
        try {
            /* 通信の準備をする */
            BufferedReader reader =        //キーボードから接続するサーバ名を読み込む
                    new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Server name(localhost or 133.27.....)? >");
            String serverName = reader.readLine();
            Socket socket =            //指定されたサーバの5000番ポートに接続を要求する
                    new Socket(serverName, 5002);

            /* キーボードから所持金を読み込む */
            System.out.print("所持金を入力してください>");
            int money = 0;
            while(true) {
                try {
                    String lineStr = reader.readLine();
                    money = Integer.parseInt(lineStr);
                    if(money < 1400) {
                        System.out.print("買える商品がありません。再度所持金を入力してください>");
//                        lineStr = reader.readLine();
//                        money = Integer.parseInt(lineStr);
                        continue;
                    }else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.print("数字を入力してください>");
                }
            }
//            System.out.println(money);
            /* 所持金をサーバに送る */

            CPSLabMarket wallet = new CPSLabMarket();
            wallet.setClientWallet(money);

            ObjectOutputStream oos =
                    new ObjectOutputStream(socket.getOutputStream());

            oos.writeObject(wallet);
            oos.flush();


            /* サーバから判定結果を受信する */
            ObjectInputStream ois =
                    new ObjectInputStream(socket.getInputStream());

            CPSLabMarket market = (CPSLabMarket) ois.readObject();
            Map<String, Integer> goods = new HashMap<String, Integer>();
            goods = market.getGoodsList();
            System.out.println("あなたの所持金で買える商品は\n");
            for (String key : goods.keySet()) {
                System.out.println("商品: " + key + ", 価格: " + goods.get(key) + "円");
            }
            System.out.println("\nです。");
            System.out.println("なにを購入しますか?商品名を入力してください");

            String goodsName = reader.readLine();
            while (!market.getGoodsList().containsKey(goodsName)) {
                System.out.println("入力に誤りがあります。再度商品名を入力してください");
                goodsName = reader.readLine();
            }
            market.setGoodsName(goodsName);
            oos.writeObject(market);
            oos.flush();

            CPSLabMarket changeSection = (CPSLabMarket) ois.readObject();
            int change = changeSection.getChange();
            System.out.println("購入しました。お釣りは " + change + " 円になります。");
            System.out.println("ご利用ありがとうございました");
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
