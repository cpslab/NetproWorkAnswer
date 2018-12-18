package exam.A;


import java.util.Random;

public class CenterKamoku {
    private String name= "";
    private int score = 0;

    public CenterKamoku(String name){
        Random random = new Random();
        this.name = name;
        this.score = random.nextInt(100);
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
