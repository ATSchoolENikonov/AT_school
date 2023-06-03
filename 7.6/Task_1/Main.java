package Task_1;

public class Main {
    public static void main(String[] args) {
        Basket<Fruit> fruitBasket = new Basket<>();
        Basket<Vegetable> vegetableBasket = new Basket<>();
        Apples apples = new Apples();
        Banana banana = new Banana();
        Tomato tomato = new Tomato();
        Cucumber cucumber = new Cucumber();
        fruitBasket.addItem(apples);
        fruitBasket.addItem(banana);
        vegetableBasket.addItem(cucumber);
        vegetableBasket.addItem(tomato);
//        fruitBasket.addItem(cucumber);
//        fruitBasket.addItem(tomato);
//        vegetableBasket.addItem(apples);
//        vegetableBasket.addItem(banana);
        for (int i = 0; i < fruitBasket.getBasket().length; i++) {
            System.out.println(fruitBasket.getBasket()[i]);
        }
        for (int i = 0; i < vegetableBasket.getBasket().length; i++) {
            System.out.println(vegetableBasket.getBasket()[i]);
        }
    }
}
