public class RandomWalker {
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int steps=0;  //how many steps have walked
        int node=0;  //current position
        while (node!=n && node!=-1*n)
        {
            double r = Math.random();
            if (r<0.5)  //move left
                node--;
            else       //move right
                node++;
            steps++;
        }
        System.out.println(steps);
    }
}
