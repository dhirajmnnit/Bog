
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Dhiraj
 */
public class JavaApp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            long noDivisors = 0;
            long N = Long.parseLong(br.readLine());
            for (long i = 1; i * i <= N; i++) {
                if (N % i == 0 && N / i != i) {
                    noDivisors += 2;
                }
                if (N % i == 0 && N / i == i) {
                    noDivisors += 1;
                }
            }
            System.out.println(noDivisors);
        }
    }

}
