package org.softwire.training.zoo.services;

import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.CanBeMucked;
import org.softwire.training.zoo.models.Keeper;

import java.util.List;

public class MuckingScheduler {
    private static MuckingScheduler instance;

    private MuckingScheduler() {
    }

    public static MuckingScheduler getInstance() {
        if (instance == null) {
            instance = new MuckingScheduler();
        }
        return instance;
    }

    public void assignMuckingJobs(List<Keeper<? extends Animal>> keepers) {
        keepers.forEach(keeper -> keeper.getResponsibleAnimals().forEach(animal -> {
            if (animal instanceof CanBeMucked) {
                keeper.muck((CanBeMucked) animal);
            }
        }));
    }
}
