import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AsciiArt {

    static String artLetters[][] = new String[26][7];

    public  static void buildArtLib()  //建立26个字母的艺术字库
    {
        Scanner input=null;

        try
        {
            input = new Scanner(new File("ascii_art.txt"));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        for (int i=0;i<artLetters.length;i++)
        {

            for (int j=0;j<artLetters[i].length;j++)
            {
                String s = input.nextLine();
                artLetters[i][j]=s;

            }

            if (input.hasNext())
                input.nextLine();

        }

    }

    public static char match(String[] letter) //单个字母跟艺术字库匹配
    {
        int i;
        for (i = 0; i < 26; i++)
        {
            boolean isMatch=true;
            for (int j=0;j<letter.length;j++)
            {
                if (!letter[j].trim().equals(artLetters[i][j].trim()))
                {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) break;

        }

        return (char) ( (int) 'A'+i );
    }

    public static void print(String[][] s)   //调试用的，打印一个二维数组
    {
        System.out.println(s.length+"行"+s[0].length+"列");
         for (int i=0;i<s.length;i++)
            for (int j=0;j<s[i].length;j++)
            {
                if (!s[i][j].isEmpty())
                    System.out.println(s[i][j]);
            }
    }

    public static  String[][]  split(String[] lines)  //把输入的一行art字母，拆成多个字母
    {
        String[][] letters = new String[10][7] ;  //一行最多十个字母
        for (int i=0;i<letters.length;i++)  //初始化
            for (int j=0;j<letters[i].length;j++)
                letters[i][j]=" ";
        int k=0;
        int last=0;  //前一个非空列的位置
        for (int j=0;j<lines[0].length();j++)   //j代表第几列
        {
            boolean isNull = true;

            for (int i = 0; i < lines.length; i++)  //i 代表第几行
            {
                if (lines[i].charAt(j) != ' ')
                {
                    isNull = false;
                    break;
                }
            }
            if (isNull)  //第j列是空列，也就是字母的分隔
            {
                //System.out.println("the empty column="+j);
                for (int i=0;i<7;i++)
                    letters[k][i]=lines[i].substring(last,j);  //截取从last到j-1列
                last = j+1;
                k++;



            }
        }
        return letters;


    }

    public static void main(String[] args) throws FileNotFoundException {
        buildArtLib();
        //Scanner input= new Scanner(System.in);  //键盘输入
        Scanner input= new Scanner(new File("sample_input.txt"));  //文件输入
        int n = Integer.parseInt(input.nextLine());

        for (int i=0;i<n;i++)
        {
            String s = input.nextLine(); //第一个空行不处理
            String[] lines = new String[7];
            for (int j=0;j<7;j++)
            {
                s = input.nextLine();
                lines[j]=s;
                //System.out.println("s="+s);
            }
            String[][] letters =  new String[10][7];
            letters =   split(lines);
            for (int l=0;l<letters.length;l++)
                if (letters[l][0]!=" ")
                    System.out.print(match(letters[l]));
            System.out.println();
        }
    }
}
