public class Homework_4 {
    public static void main(String[] args) {
        Integer p = new Integer(args[0]);
        Double r = new Double(args[1]);
        Integer t = new Integer(args[2]);
        System.out.println("Money: " + p);
        System.out.println("Coefficient: " + r);
        System.out.println("Time: " + t + " years");
        System.out.println("Result: " + p * Math.exp(r * t));
    }
}
