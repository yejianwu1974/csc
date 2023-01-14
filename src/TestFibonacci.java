import java.util.*;

public class TestFibonacci
{
    static Scanner input = new Scanner(System.in);

    // here is the function you need to implement

	public static void parse_line(int n, int d)
    {
        int m=10000;
        int[] a = new int[m];

        a[0]=1;
        a[1]=1;
        int i=2;
        if(n<d)
            System.out.println("invalid");
        else if(n==0||d==0)
            System.out.println(" ");
        else if(n>=d)
        {
            while (i <= m - 1)
            {

                a[i] = a[i - 1] + a[i - 2];
                i++;
            }
            for (int j = (n - 1); j > (n - d); j--)
            {
                System.out.print(a[j] + ", ");
            }
            System.out.println(a[n - d]);
        }
    }

    public static void main(String[] args) throws Exception
    {
        int line_number = Integer.parseInt(input.nextLine()); 
        for(int i=0; i<line_number; i++)
        {
            String s = input.nextLine();
            String t[] = s.split(", ");
            int n = Integer.parseInt(t[0]);
            int d = Integer.parseInt(t[1]);
            TestFibonacci.parse_line(n, d);
        }
    }
}