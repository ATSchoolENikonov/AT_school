package Task_2;

import java.util.Iterator;


public class Main {

    void makeSalad(Basket<? extends Plant> baskettt) {
        Iterator<Plant> it= baskettt.iterator();
        System.out.println("```" + "\nГотовим салатик: " );
        System.out.print("\n Режем ");
        while(it.hasNext()){
            System.out.print(it.next().getName() + " ");
        }
        System.out.println("\nУгощайся!\n" +
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
