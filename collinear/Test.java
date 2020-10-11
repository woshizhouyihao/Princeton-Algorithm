/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Test {
    public static void main(String[] args) {
        int N = 6;
        // int[] list = new int[N];
        // for (int i = 0; i < N; i++) list[i] = i;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int m = i; m < N - 1; m++) {
                    // int count = j;
                    for (int k = j + 1; k < N; k++) {
                        StdOut.println(i + " " + j + " " + m + " " + k);
                    }
                    // count++;
                }
            }
        }
    }
}

