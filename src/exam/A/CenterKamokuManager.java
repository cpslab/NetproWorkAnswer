package exam.A;

public class CenterKamokuManager {
    /*
       - この回答例では個々の科目をオブジェクトにまとめています。
       - printAverageメソッドとprintMaxKamokuメソッドはintとvoidの違いを明確にするためにあえて片方はint, 片方はvoidで実装しています。
         必ずしもこうしなくてはいけないというわけではありません。
     */

    public static void main(String[] args) {
        CenterKamokuManager ckm = new CenterKamokuManager();
        CenterKamoku[] kamoku = new CenterKamoku[5];

        kamoku[0] = new CenterKamoku("英");
        kamoku[1] = new CenterKamoku("国");
        kamoku[2] = new CenterKamoku("数");
        kamoku[3] = new CenterKamoku("社");
        kamoku[4] = new CenterKamoku("理");

        for (int i = 0; i < kamoku.length; i++) {
            System.out.println(kamoku[i].getName()+ ":" + kamoku[i].getScore());
        }
        ckm.printMaxKamoku(kamoku);

        System.out.println("5科目の平均は:" + ckm.printAverage(kamoku) + "点");
    }

    public int printAverage(CenterKamoku[] kamoku){
        int sum = 0;
        int average = 0;
        for (int i = 0; i < kamoku.length; i++) {
            sum += kamoku[i].getScore();
        }
        average = sum / kamoku.length;
        return average;
    }

    public void printMaxKamoku(CenterKamoku[] kamoku){
        int max = 0;
        String name = "";
        for (int i = 0; i < kamoku.length; i++) {
            if(max < kamoku[i].getScore()){
                max = kamoku[i].getScore();
                name = kamoku[i].getName();
            }else{
                continue;
            }
        }
        System.out.println("最高点は" + max + "点の" + name + "です。");
    }


}

