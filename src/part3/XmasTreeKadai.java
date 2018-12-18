package part3;

public class XmasTreeKadai {
    public static void main(String[] args) {
        // 葉の部分の高さを20としたとき、IntelliJでは
        // [Run] → [Edit Configurations..] → [Program arguments]に20と設定し実行
        int X = Integer.parseInt(args[0]);

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < X - i; j++) {
                if((i + j + 1) % 3 == 1){
                    System.out.print("+");
                }else{
                    System.out.print(" ");
                }
            }
            for (int j = 0; j < i * 2; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < X + 2; i++) {
                if(i >= X - 2) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
