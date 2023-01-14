public class Lecture_9_15 {
    public static void main(String[] args) {
        String s1 = new String("*");
        String s2 = new String("*");
        String s3 = s1;
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1==s3);
    }
}