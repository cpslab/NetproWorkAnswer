package part2;

import java.io.*;    // C言語では、#include に相当する
import java.util.Calendar;

public class Kadai2{

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        int counter=1;
        String gengo = "元号";
        int gengoyear = 0;
        int birthyear = 1900;
        int age = 0;
        int futureage = 0;

        while(true){
            try {
                System.out.println("========="+(counter++)+"回目の質問");
                System.out.println("あなたの年齢を入力してください");
                String line = reader.readLine();
                if(line.equals("q") || line.equals("0")){
                    System.out.println("終了します");
                    break;
                }else if(Integer.parseInt(line) < 0 || Integer.parseInt(line) > 120){
                    System.out.println("入力に誤りがあります。再度入力してください");
                    continue;
                }

                age = Integer.parseInt(line);
                birthyear = year - age;
                futureage = 2020 - birthyear;

                if(birthyear >= 1912 && birthyear < 1926) {
                    gengo = "大正";
                    gengoyear = birthyear - 1911;
                }
                else if(birthyear >= 1926 && birthyear < 1989) {
                    gengo = "昭和";
                    gengoyear = birthyear - 1925;
                }
                else if(birthyear >= 1989) {
                    gengo = "平成";
                    gengoyear = birthyear - 1988;
                }
                else {
                    gengo = "明治";
                    gengoyear = birthyear - 1867;
                }
                switch (gengoyear){
                    case 0:
                        System.out.println("あなたは" + birthyear+ "年生まれですね。");
                        break;
                    case 1:
                        System.out.println("あなたは" + birthyear + "年生まれですね。"+ gengo +"元年"+"生まれです。");
                        break;
                    default:
                        System.out.println("あなたは" + birthyear + "年生まれですね。"+ gengo + gengoyear +"生まれです。");
                        break;
                }
                System.out.println("2年後の東京オリンピック2020年には、" + futureage + "歳ですね。(; ;)orz");
            }
            catch(IOException e) {
                System.out.println(e);
            }
        }


    }
}
