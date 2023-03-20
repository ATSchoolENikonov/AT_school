public class Task_6 {
    public static void main(String[] args) {
        Integer m = Integer.valueOf(args[0]);
        if(m<0){
            System.out.println("Ошибка");
            System.exit(22);
        }else {
            Timer timer = new Timer(m);
            timer.start();
        }
    }
}
