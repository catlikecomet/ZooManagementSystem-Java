package org.softwire.training.zoo.services;

import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.CanBeStroked;
import org.softwire.training.zoo.models.Keeper;

import java.util.List;

public class StrokingScheduler {
    private static StrokingScheduler instance;

    private StrokingScheduler() {
    }

    public static StrokingScheduler getInstance() {
        if (instance == null) {
            instance = new StrokingScheduler();
        }
        return instance;
    }

    public void assignStrokingJobs(List<Keeper<? extends Animal>> keepers) {
        keepers.forEach(keeper -> keeper.getResponsibleAnimals().forEach(animal -> {
            if (animal instanceof CanBeStroked) {
                keeper.stroke((CanBeStroked) animal);
            }
        }));
    }
}
