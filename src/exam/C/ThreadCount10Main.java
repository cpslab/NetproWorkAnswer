package exam.C;

public class ThreadCount10Main {
    public static void main(String[] args){
        /*
           - numはthreadの個数
           - スレッドIDであるA-Zのローマ字はchar型を用いることでA, B, C, ... という文字を生成しています。
             仕組みとしては、char型は10進数の文字コードを読み込むことができるため、65(=A), 66(=B), 67(=C)...というふうに表すことができます。
             他にも数字で表せる文字はたくさんあるので、詳しくは「asciiコード表」を検索してみてください。
           - スレッドの実行結果は処理時間に寄るので毎度スレッドIDの並びは異なる場合があります。
           - sleepingはミリ秒なので1000ミリ秒 = 1秒であることに注意してください。
         */
        System.out.println("※スレッドIDはローマ字, i=以下がカウンター");
        int num = 10;
        CountTenRunnableImpleC[] ct = new CountTenRunnableImpleC[num];

        for (int i = 0; i < num; i++) {
            int sleepingTime  = i * 1000;
            ct[i] = new CountTenRunnableImpleC(sleepingTime, (char)(i + 65), 10);
            Thread th = new Thread(ct[i]);
            th.start();
        }
    }
}

class CountTenRunnableImpleC implements Runnable{
    int sleeping;
    char s;
    int loop;

    CountTenRunnableImpleC(int sleeping, char s, int loop){
        this.sleeping = sleeping;
        this.s = s;
        this.loop = loop;
    }

    public void run() {
        try {
            for(int i = 0; i < loop; i++) {
                System.out.println(s + ":i=" + i);
                Thread.sleep(sleeping);  // ()の中はミリ秒
            }
        }
        catch(InterruptedException e) {
            System.err.println(e);
        }

    }
}
