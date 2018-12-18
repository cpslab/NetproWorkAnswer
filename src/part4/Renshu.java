package part4;

class Renshu{
    public static void main(String[] args){
        new Renshu();
    }
    public Renshu(){//コンストラクタ

    }
    void printHello(){
        System.out.println("Hello World");
    }
    void printHello2(){
        int i = 0;
        while(i < 2) {
            printHello();
            i++;
        }
    }
    void printHellos(int n){
        int i = 0;
        while(i < n) {
            printHello();
            i++;
        }
    }
    void calc1(int x){
        if (x < 10) {
            System.out.println("small number");
        }
    }
    int calc2(int x){
        return x * 2;
    }


    float calc3(float x) {
        return x * 2;
    }

    int calc4(int x, int y) {
        return (x + y) * 2;
    }

    int calc5(int x, int y, int z) {
        return (x + y + z) * 2;
    }

    int sum(int n){
        int i = 1;
        int sum = 0;
        while (i <= n){
            sum += i;
            i++;
        }
        return sum;
    }

    int sum(int p, int q) {
        int sum = 0;
        for (int i = p; i <= q; i++) {
            sum += i;
        }
        return sum;
    }

    int sum(int[] a, int index){
        int sum = 0;
        if(index < a.length && index >= 0){
            for (int i = index; i < a.length; i++) {
                   sum += a[i];
            }
            return sum;
        }else{
            System.out.println("Index Error!");
            return -1;
        }
    }

    int selectMaxValue(int[] a) {
        int MAX = 0;
        for (int i = 0; i < a.length; i++) {
            if(MAX < a[i]){
                MAX = a[i];
            }else{
                continue;
            }
        }
        return MAX;
    }

    int selectMaxIndex(int[] a) {
        int index = 0;
        int MAX = 0;
        for (int i = 0; i < a.length; i++) {
            if(MAX < a[i]){
                MAX = a[i];
                index = i;
            }else{
                continue;
            }
        }
        return index;
    }

    int selectMinIndex(int[] a) {
        int index = 0;
        int min = 0;
        for (int i = 0; i < a.length; i++) {
            if(min > a[i]){
                min = a[i];
                index = i;
            }else{
                continue;
            }
        }
        return index;
    }


    int selectDiffMaxMinValue(int[] p) {
        return selectMaxValue(p) - p[selectMinIndex(p)];
    }

    void swapArrayElements(int[] p, int i, int j) {
        int a = p[i];
        p[i] = p[j];
        p[j] = a;
    }

    int selectMaxIndex(int[] a, int i, int j){
        int index = 0;
        int MAX = 0;
        for (int k = i; k < j; k++) {
            if(MAX < a[k]){
                MAX = a[k];
                index = k;
            }else{
                continue;
            }
        }
        return index;
    }


    boolean swapTwoArrays(int[] a, int[] b) {
        if(a.length == b.length){
            int register = 0;
            for (int i = 0; i < a.length; i++) {
                register = a[i];
                a[i] = b[i];
                b[i] = register;
               // System.out.println(a[i] + " ," + b[i]);
            }
            return true;

        }else{
            return false;
        }
            
    }
    
    //swapTwoArrays　他解答
//    public boolean swapTwoArrays(int[] a, int[] b) {
//        if (a.length != b.length) return false;
//        int[] tmp = new int[a.length];
//        System.arraycopy(a, 0, tmp, 0, a.length);
//        System.arraycopy(b, 0, a, 0, a.length);
//        System.arraycopy(tmp, 0, b, 0, a.length);
//        return true;
//    }
}//Renshu class end

