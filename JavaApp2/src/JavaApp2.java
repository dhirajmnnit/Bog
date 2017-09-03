
import java.io.*;
/**
 *
 * @author Dhiraj
 */
/* Problem Statement:
Given an integer N print total number of divisors of N. It is guaranteed that N is a 
multiple of prime numbers less than 10^6.

Input
First line contains T (number of test cases).
Next T lines contains integer N.

Constraints
1 <= T <= 100
1 <= N <= 10^18

SAMPLE INPUT
6
1
2
3
4
5
20


SAMPLE OUTPUT
1
2
2
3
2
6

*/
public class JavaApp2 {

    static int prime[];
    static int size;

    static void getPrime() {
        int limit = 1000000;
        prime = new int[limit + 1];
        prime[0] = 1;
        prime[1] = 1;
        for (int i = 2; i * i <= limit; i++) {
            if (prime[i] == 0) {
                for (int j = 2 * i; j <= limit; j += i) {
                    prime[j] = 1;
                }
            }
        }
        int j = 0;
        for (int i = 2; i <= limit; i++) {
            if (prime[i] == 0) {
                prime[j] = i;
                j++;
            }
        }
        size = j;
    }

    static long countDivisors(long N) {
        long result = 1;
        int i = 0;
        for (int temp = prime[i]; temp * temp <= N; temp = prime[++i]) {
            int count = 0;
            while (N % temp == 0) {
                count++;
                N = N / temp;
            }
            result = result * (count + 1);

        }
        if (N != 1) {
            result = result * 2;
        }
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        getPrime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            long N = Long.parseLong(br.readLine());
            long noDivisors = countDivisors(N);
            System.out.println(noDivisors);
        }
    }
}
