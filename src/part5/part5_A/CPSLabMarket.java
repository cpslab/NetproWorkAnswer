package part5.part5_A;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CPSLabMarket implements Serializable{
    /*
    HashMap goodsList: 購入できる商品リスト
    String goodsName: クライアントが買いたい商品の名前
    int clientWallet: クライアントの所持金
    int change: おつり

     */

    public Map <String, Integer> goodsList = new HashMap<String, Integer>();
    String goodsName = "";
    int clientWallet = 0;
    int change = 0;

    public Map<String, Integer> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(Map<String, Integer> goodsList) {
        this.goodsList = goodsList;
    }

    public void setClientWallet(int money) {
        this.clientWallet = money;
    }

    public int getClientWallet() {
        return clientWallet;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int getChange() {
        return change;
    }
}
