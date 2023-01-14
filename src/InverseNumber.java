public class InverseNumber {
    public static void main(String[] args)
    {
        String s = args[0];
        int m=s.length();
        char a[] = s.toCharArray();

        for (int i=0;i<m;i++)
        {
            if (a[i]!=a[m-1-i])
            {
                System.out.println("false");
                return;
            }

        }
        System.out.println("true");
    }
}
