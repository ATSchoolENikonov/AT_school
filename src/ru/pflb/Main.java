package ru.pflb;

import ru.pflb.details.Engine;
import ru.pflb.professions.Driver;
import ru.pflb.vehicles.Car;
import ru.pflb.vehicles.Lorry;
import ru.pflb.vehicles.SportCar;
import ru.pflb.vehicles.VehicleClass;

public class Main {
    public static void main(String[] args) {
        Engine eng = new Engine(40, "Mitsubisi");
        Driver drive = new Driver(33, "Vasya", 12, 334455);
        Car car1 = new Car("Djigul", VehicleClass.SMALL, 23.3, drive, eng);
        System.out.println(car1 + "\n" + "=====================");

        Lorry lor = new Lorry("Kamaz", VehicleClass.LARGE, 44.4, drive, eng, 12.3);
        System.out.println(lor + "\n" + "=====================");

        SportCar sport = new SportCar("ferrari", VehicleClass.SPORTS_CAR, 22.2, drive, eng, 133);
        System.out.println(sport + "\n" + "=====================");
        sport.start();
        sport.turnLeft();
        sport.turnRight();
        sport.stop();
    }
}
