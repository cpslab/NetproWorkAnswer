package part5.part5_Z;

import java.io.Serializable;

public class TaskObj implements Serializable, ITask {
    int number = 0;
    int result = 0;

    @Override
    public void setExecNumber(int number) {
        this.number = number;
    }

    @Override
    public void exec() {
        for (int i = 2; i <= number; i++) {
            if(isPrime(i) == true) result = i;
        }
    }

    @Override
    public int getResult() {
        return result;
    }

    public static boolean isPrime(int num) {
        if(num == 2)return true;
        else if (num % 2 == 0) return false;

        double sqrtNum = Math.sqrt(num);
        for (int i = 3; i <= sqrtNum; i += 2)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}
