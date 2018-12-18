package middle_exam;

public class Q3 {
    public static void main(String[] args) {
        int a = 1900;
        if(a % 4 == 0){
            System.out.println(a + "は閏年です。");
        }else if(a%100 == 0){
            System.out.println(a + "は平年です。");
        }else if (a % 400 == 0){
            System.out.println(a + "は閏年です。");
        }else{
            System.out.println(a + "は平年です。");
        }
    }
}
