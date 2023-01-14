public class TestString {
    public static void  main (String[] args)
    {
        String s="abcde";
        int n=s.length();
        char[] a  = s.toCharArray();
        char[] b = new char[n];
        for (int i=0,j=n-1;i<n;i++,j--)
        {
            b[j]=a[i];
        }
        System.out.println(String.valueOf(b));
    }
}
