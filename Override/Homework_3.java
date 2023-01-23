public class Homework_3 {
    public static void main(String[] args) {
        Integer a=new Integer(args[0]);
        Integer b=new Integer(args[1]);
        boolean isCorrect=(a%b==0);
        System.out.println(a);
        System.out.println(b);
        System.out.println(isCorrect);
    }
}
