package part3;

import java.util.Arrays;
import java.util.Random;

public class HeikinBKadai {
    public static final int N=100;
    Kamoku[] kamoku = new Kamoku[N];
    static String kamokuname="数学";

    public static void main(String[] args) {
        HeikinBKadai heikinb= new HeikinBKadai(kamokuname);
        heikinb.initalizeScores();
        heikinb.printAverage();
        heikinb.gokakusha();

    }

    HeikinBKadai(String s){
        this.kamokuname=s;
    }
    void initalizeScores(){
        Random r = new Random();

        for(int i=0;i<N;i++){
            int score = r.nextInt(N+1);
            kamoku[i]= new Kamoku(score);

        }

    }

    void printAverage(){
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=kamoku[i].getScore();
        }
        System.out.println("平均点は"+sum/N);

    }

    void gokakusha(){
        //昇順はa.score - b.score
        Arrays.sort(kamoku, (a,b)-> b.score - a.score);
        for (int i = 0; i < kamoku.length; i++) {
            if(kamoku[i].score >= 80) {
                System.out.println(kamoku[i].score);
            }
        }
    }
}
