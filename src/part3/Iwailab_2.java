package part3;

import java.util.Random;
public class Iwailab_2 {

    int[][] data = new int[25][3];

    public static void main(String args[]) {
        Iwailab_2 iwailab = new Iwailab_2();
        iwailab.initializeData();
        double result = iwailab.calculate();
        System.out.println(result);
    }

    Iwailab_2(){

    }

    private void showData() {
        for (int i=0; i < 25; i++) {
            System.out.println();
            for(int j=0; j < 3; j++) {
                System.out.print(data[i][j]);
                System.out.print(" ");
            }
        }
    }

    private void initializeData() {
        Random r = new Random();
        for (int i=0; i < 25; i++) {
            data[i][0] = 120 + (r.nextInt(20) - 10); // 学生の総数
            data[i][1] = 20 + i; // 女性の割合 (%)
            data[i][2] = 10 + (r.nextInt(6) - 3); // 岩井研の配属人数
        }
    }

    // 25年間岩井研に女性が入らない確率を計算する
    private double calculate() {
        double result = 1;
        for (int i=0; i < 25; i++) {
            int womanNumber = (int) (data[i][0] * ((double)data[i][1] / 100)); // 女性の数
            double eachResult = 1;
            for (int j=0; j < womanNumber; j++) {
                eachResult *= (double)(data[i][0] - data[i][2] - j) / (data[i][0] - j); // j 人目の女性が岩井研に入らない確率を掛けていく
            }
//            System.out.println(String.format("%d: %f %%", i + 1, eachResult * 100)); // i + 1 年目の女性が岩井研に入らない確率を表示
            result *= eachResult;
        }

        return result;
    }
}

