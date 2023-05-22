package Task_2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    void makeSalad(Basket baskettt) {
        System.out.println("```" + "\nГотовим салатик: " + "\n Режем " + baskettt.iterator() + "\nУгощайся!\n" +
                "```");
    }

    public static void main(String[] args) {
        Main norBasket = new Main();
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
        norBasket.makeSalad(fruitBasket);
        norBasket.makeSalad(vegetableBasket);
    }
}
