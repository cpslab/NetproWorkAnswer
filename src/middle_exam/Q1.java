package middle_exam;

public class Q1 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {

                /* Q1-1 */
                int val = i * j;

                /* Q1-2 */
                if(val < 10){
                    System.out.print(" "+ val + "|");
                }else{
                    System.out.print(val + "|");
                }
            }
            /* Q1-3 */
            System.out.println("");
        }

    }
}
