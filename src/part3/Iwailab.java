package part3;

import java.util.Random;

public class Iwailab{
    public static final int years = 25;
    public static final int columns = 3;

    public static void main(String[] args) {
        int[][] members = new int[years][columns];
        Random random = new Random();
        double totalRatio = 1;
        for (int i = 0; i < years; i++) {
            //学生の総数
            members[i][0] = 120 + (random.nextInt(20) - 10);
            //女性の割合(%)
            members[i][1] = 20 + i;
            //岩井研の人数
            members[i][2] = 10 + (random.nextInt(6) - 3);

            // 男性数を求める
            int men = members[i][0] - (int)(members[i][0] * ((float)members[i][1] / 100));
            // 総数から岩井研の人数を取り出す組み合わせ
            long cpsRatio = combination(members[i][0], members[i][2]);
            // 男性の中から岩井研のメンバーを取り出す組み合わせ
            long menRatio = combination(men, members[i][2]);
            // 岩井研の人数に男性しか入らない割合
            totalRatio *= (double) menRatio / cpsRatio;
        }
        System.out.println(totalRatio);
    }
    //Combination
    public static final long combination(final int n, int r) {
        if (n < 0 || r < 0 || n < r) {
            throw new ArithmeticException("n = " + n + ", r = " + r);
        }

        r = Math.min(r, n - r);    //nCr = nCn-r
        if (r == 1) {
            return n;
        }

        long sum = 1;
        for (int i = 1; i <= r; i++) {
            //漸化式 : nCr = (n - r + 1) / r * nCr-1 を利用
            sum = sum * (n - i + 1) / i; //漸化式(r(i)で割り切るのに、先に nCr-1 が必要なため、 sum *= ～ としない)
        }
        return sum;
    }
}
