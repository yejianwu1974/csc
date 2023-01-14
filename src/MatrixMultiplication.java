import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int m = myObj.nextInt();
        int n = myObj.nextInt();
        int p = myObj.nextInt();
        int[][] a = new int[m][n];
        int[][] b = new int[n][p];
        int[][] c = new int[m][p];
        //将矩阵a填满
        if (myObj.hasNextInt()) {
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    a[i][j] = myObj.nextInt();
                }
        }
        //将矩阵b填满
        if (myObj.hasNextInt()) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < p; j++) {
                    b[i][j] = myObj.nextInt();
                }
        }
        //调用函数，计算结果矩阵c
        c = multi(a, b, m, n, p);
        System.out.println(m + " " + p);
        for (int i = 0; i < m; i++)

            for (int j = 0; j < p; j++) {
                if (j < p - 1) {
                    System.out.print(c[i][j]+" ");
                }
                else if(j==p-1)
                    System.out.println(c[i][j]);
            }

    }


    public static int[][] multi(int a[][], int b[][], int m, int n, int p) {
        int[][] result = new int[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++)
                    result[i][j] = result[i][j] + a[i][k] * b[k][j];
            }
        }
        return result;
    }
}




