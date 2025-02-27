package org.softwire.training.zoo.models;

import java.util.ArrayList;
import java.util.List;

public class Keeper<T extends Animal> {
    private List<T> animals;

    public Keeper(List<T> animals) {
        this.animals = new ArrayList<>(animals);
    }

    public void startLookingAfter(T animal) {
        this.animals.add(animal);
    }

    public void groom(CanBeGroomed animal) {
        animal.groom();
    }

    public void stroke(CanBeStroked animal){
        animal.stroke();
    }

    public void feed(Animal animal) {
        animal.feed();
    }

    public void muck(CanBeMucked animal){animal.muck();}

    public List<T> getResponsibleAnimals() {
        return new ArrayList<>(animals);
    }
}
