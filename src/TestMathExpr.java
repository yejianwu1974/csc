import  java.util.*;

public class TestMathExpr {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            double result = parse(input.nextLine());
            System.out.println(String.valueOf(Math.round(result)));

        }
    }
    public static double parse(String s)
    {
        //first:seperate s into a few single elements,include
        //  1、 number,such as -3.4 2
        //  2、 operator + - * /
        //  3、in testb,it will include ( ) ,and function
        String[] expr = sepearte(s);
        //second :calculate the expr
        double result = calculate(expr);
        return result;
    }

    public static String[] sepearte(String s)
    {

        String[] expr = new String[20]; //no more than 5 operator
        if (s.isEmpty() || s.equals(""))
            return  expr;
        String tmp_str = "";
        int j=0;

        for (int i=0;i<s.length();i++)
        {
            if (s.charAt(i)==' ')
                continue;
            if ((s.charAt(i)>='0' && s.charAt(i)<='9') ||s.charAt(i)=='.'||(i==0 && s.charAt(i)=='-'))
                tmp_str=tmp_str+s.charAt(i);
            else
            {
                expr[j]=tmp_str;
                tmp_str="";
                j++;
                expr[j]=String.valueOf(s.charAt(i));
                j++;
            }

            if (i==s.length()-1)  //end of line
                expr[j]=tmp_str;

        }

        String[] str_new = new String[j+1];
        for (int k=0;k<str_new.length;k++)
            str_new[k]=expr[k];
        return str_new;


    }

    public static double calculate(String[] expr)
    {

        if (expr.length==3)  //only 3 elements
        {
            int i=1;    //operator position
            String operator= expr[i];
            double num1 = Double.parseDouble(expr[i-1]);
            double num2 = Double.parseDouble(expr[i+1]);
            return evalTwoNums(operator,num1,num2 );
        }

        int i=hasMultOrDiv(expr);
        if (i==-1) //if i==-1 then the expr has no * or /
            i=1;
        String operator= expr[i];
        double num1 = Double.parseDouble(expr[i-1]);
        double num2 = Double.parseDouble(expr[i+1]);
        double result= evalTwoNums(operator,num1,num2 );
        expr[i-1]=String.valueOf(result);

        //reorganize the expr array
        String[] s = new String[expr.length-2];
        int k=0;
        for (int j=0;j<s.length;k++)
        {
            if (k==i ||k==i+1)
               continue;
            s[j]=expr[k];
            j++;
        }
        expr=s;
        return calculate(expr);     //recursive call
    }
    public static double evalTwoNums(String operator,double num1,double num2)
    {
        if (operator.equals("+"))
            return num1 + num2;
        if (operator.equals("-"))
            return num1 - num2;
        if (operator.equals("*"))
            return num1*num2;
        if (operator.equals("/"))
            return num1 / num2;
        return 0;
    }
    public static int  hasMultOrDiv(String[] expr)
    {
        for (int i=0;i<expr.length;i++)
            if ( expr[i].equals("*") || expr[i].equals("/"))
                return i;
            return  -1;

    }

}
