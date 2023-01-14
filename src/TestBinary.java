public class TestBinary {
    public static void  main(String [] args)
    {
        int a = 2147483647;
        System.out.println("a="+binary(25));
        int b = -2147483647;
        System.out.println("b="+binary(12));

    }

    public static String binary(int N )
    {
        if (N==1) return "1";
        return binary(N/2)+ (N % 2);
    }


}
