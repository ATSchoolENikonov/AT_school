package Task_2;


public class Main{

     static<T extends Plant>  void makeSalad(Basket<T> baskettt) {
        System.out.println("```" + "\nГотовим салатик: " );
        System.out.print("Режем ");
        for (T item: baskettt) {
            System.out.print(item + " ");
        }
        System.out.println("\nУгощайся!\n" +
                "```");
    }

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
        Main.makeSalad(fruitBasket);
        Main.makeSalad(vegetableBasket);
    }
}
