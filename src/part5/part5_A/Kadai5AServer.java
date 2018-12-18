package part5.part5_A;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Kadai5AServer {
    public static void main(String arg[]){
        Map<String, Integer> goodsList = new HashMap<String, Integer>();
        goodsList.put("残留申請トートバッグ", 1730);
        goodsList.put("残留申請マグカップ", 1390);
        goodsList.put("残留申請Tシャツ", 2080);
        goodsList.put("岩井先生の顔写真付きトートバッグ", 1730);
        goodsList.put("岩井先生の顔写真付きマグカップ", 1390);
        goodsList.put("岩井先生の顔写真付きTシャツ", 2080);

        try {
            /* 通信の準備をする */
            ServerSocket server =
                    new ServerSocket(5002);        //ポート番号を指定し、クライアントとの接続の準備を行う
            System.out.println("server is waiting halloweenpresent at 5002");
            while (true){
                try {
                    Socket socket = server.accept();    //クライアントからの接続要求を待ち、
                    // 要求があればソケットを取得し接続を行う
                    System.out.println("connected");

                    /* 所持金を受信する */
                    ObjectInputStream ois =
                            new ObjectInputStream(socket.getInputStream());

                    /* 所持金から購入可能な商品リストを作成*/
                    CPSLabMarket market = (CPSLabMarket) ois.readObject();
                    int money = market.getClientWallet();
                    System.out.println(money);
                    Map<String, Integer> goods = new HashMap<>();

                    for (String key : goodsList.keySet()) {
                        int value = goodsList.get(key);
                        if (value < money) {
                            goods.put(key, value);
                        }
                    }
                    market.setGoodsList(goods);
                    System.out.println(goods);


                    /* 判定結果をクライアントに送信する */
                    ObjectOutputStream oos =
                            new ObjectOutputStream(socket.getOutputStream());

                    oos.writeObject(market);
                    oos.flush();

                    CPSLabMarket payment = (CPSLabMarket) ois.readObject();
                    String goodsName = payment.getGoodsName();
                    int goodsValue = payment.getGoodsList().get(goodsName);
                    int change = payment.getClientWallet() - goodsValue;

                    payment.setChange(change);
                    oos.writeObject(payment);
                    oos.flush();
                    oos.close();
                    ois.close();
                    socket.close();
                    continue;
                }catch (Exception e){
                    //close処理
                    //socketの終了。
                    server.close();
                    System.out.println("socketが切断されました。サーバを停止します。");

//                    e.printStackTrace();
                    break;
                }
            }

        }// エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("エラーが発生したのでプログラムを終了します");
        }
    }
}
