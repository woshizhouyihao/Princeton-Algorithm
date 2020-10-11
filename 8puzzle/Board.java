/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Board {
    private int[] tiles;
    private int n;

    public Board(int[][] tiles) {
        n = tiles.length;
        this.tiles = new int[n * n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.tiles[count] = tiles[i][j];
                count++;
            }
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i < n * n + 1; i++) {
            str.append(tiles[i - 1] + " ");
            if (i % n == 0) str.append("\n");
        }

        return str.toString();
    }

    public int dimension() {
        return n;
    }

    public int hamming() {
        int wrong = 0;
        for (int i = 0; i < n * n - 1; i++) {
            if (i + 1 != tiles[i]) wrong++;
        }
        return wrong;
    }

    public int manhattan() {
        int count = 0;
        int goalCol;
        int goalRow;
        int currCol;
        int currRow;
        for (int i = 1; i < n * n; i++) {
            if (i != tiles[i - 1] && tiles[i - 1] != 0) {
                if (tiles[i - 1] % n == 0) {
                    goalCol = n;
                    goalRow = tiles[i - 1] / n;
                }
                else {
                    goalCol = tiles[i - 1] % n;
                    goalRow = tiles[i - 1] / n + 1;
                }
                if (i % n == 0) {
                    currCol = n;
                    currRow = i / n;
                }
                else {
                    currCol = i % n;
                    currRow = i / n + 1;
                }
                count += Math.abs(currRow - goalRow) + Math.abs(currCol - goalCol);
            }
        }
        return count;
    }

    public boolean isGoal() {
        for (int i = 0; i < n * n; i++) {
            if (i + 1 != tiles[i]) return false;
        }
        return true;
    }

    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y instanceof Board) {
            Board b = (Board) y;
            if (this.n != b.n) return false;
            for (int i = 0; i < n * n; i++) {
                if (this.tiles[i] != b.tiles[i]) return false;
            }
            return true;
        }
        else {
            return false;
        }
    }

    public Iterable<Board> neighbors() {
        
    }

    public Board twin() {
        int count = 0;
        if (tiles[0] != 0 && tiles[1] != 0) {
            int temp = tiles[1];
            tiles[1] = tiles[0];
            tiles[0] = temp;
        }
        else {
            int temp = tiles[3];
            tiles[3] = tiles[4];
            tiles[4] = temp;
        }
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = tiles[count];
            }
        }
        return new Board(b);
    }

    public static void main(String[] args) {
        int[] l1 = StdRandom.permutation(9);
        int count = 0;
        int[][] tiles1 = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tiles1[i][j] = l1[count];
                count++;
            }
        }

        Board b1 = new Board(tiles1);
        System.out.print("\n" + b1.toString());
        StdOut.println("ham: " + b1.hamming());
        StdOut.print("man:" + b1.manhattan());
    }
}
