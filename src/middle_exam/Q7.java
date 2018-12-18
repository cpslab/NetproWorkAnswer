package middle_exam;

public class Q7 {
    private static double dotProduct(double x[], double y[]){
        double inner_product = 0;
        for (int i = 0; i < x.length; i++) {
            inner_product += x[i] * y[i];
        }
        return inner_product;
    }

    public static void main(String[] args) {
//        double x[] = {-2.5, 3.2, 4.0, -12.0};
//        double y[] = {10.0, 0.5, 5.0, -1.0};
        double x[] = {2, -1};
        double y[] = {-3, 0};
        System.out.println("Inner product (x, y) = " + dotProduct(x, y));
    }
}
