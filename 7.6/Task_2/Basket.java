package Task_2;

public class Basket <T>{
    public  Object[] basket = new Object[5];

    public void addItem(T fr) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = fr;
                return;
            }
        }
    }

}
