package Task_1;

public class Basket <T>{
    private Object[] basket = new Object[5];

    public Object[] getBasket() {
        return basket;
    }

    public void addItem(T fr) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = fr;
                return;
            }
        }
    }

}
