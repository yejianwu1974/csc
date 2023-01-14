public class MaxofThreeNums {
    public static void main(String[] args)
    {
        double a=5;
        double b=10;
        double c=13;
        System.out.println(max(a,b,c));
    }
    public static double max(double a,double b,double c)
    {
        return a>b?(a>c?a:c):(b>c?b:c);
    }
}
