package ru.pflb.professions;

import ru.pflb.Person;

public class Driver extends Person {
    private int driverExperience;
    private long licenceID;
    public Driver(int age, String name,int driverExperience,long licenceID) {
        super(age, name);
        this.driverExperience=driverExperience;
        this.licenceID=licenceID;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                +"-driverExperience: " + driverExperience +"\n"
                +"-licenceID: "+ licenceID;
    }
}
