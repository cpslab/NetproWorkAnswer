package middle_exam;

public class Q9 {
    public static void main(String[] args) {
        new Q9();
    }
    public Q9(){
        Kamoku[] kamokus = new Kamoku[5];
        for (int i = 0; i < kamokus.length ; i++) {
            kamokus[i] = new Kamoku();
            int rand= (int)(Math.random()*100);
            kamokus[i].setScore((int)(Math.random()*100));
        }
        System.out.println("Averageは" + getAverage(kamokus) + "です。");
    }

    public int getAverage(Kamoku[] k){
        int sum = 0;
        int average = 0;
        for (int i = 0; i < k.length; i++) {
            sum += k[i].getScore();
        }
        average = sum / k.length;
        return average;
    }

    class Kamoku{
        String name;
        int score = 0;
        Kamoku(){

        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }
    }
}
