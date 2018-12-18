package middle_exam;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class Q2 {
    public static void main(String[] args) {
        try{
            /** Q2 **/
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
