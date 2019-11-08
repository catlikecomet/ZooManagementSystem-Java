package org.softwire.training.zoo;

import org.softwire.training.zoo.models.*;
import org.softwire.training.zoo.services.FeedingScheduler;
import org.softwire.training.zoo.services.GroomingScheduler;
import org.softwire.training.zoo.services.MuckingScheduler;
import org.softwire.training.zoo.services.StrokingScheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<LargeAnimal> largeAnimals = Arrays.asList(
                new Lion(LocalDate.of(2010, 4, 28)),
                new Lion(LocalDate.of(2012, 5, 11)),
                new Zebra(LocalDate.of(2008, 12, 1)),
                new SnowLeopard(LocalDate.of(2015,7,31))
        );
        List<SmallAnimal> smallAnimals = Arrays.asList(
                new Rabbit(LocalDate.of(2014, 1, 1)),
                new GuineaFowl(LocalDate.of(2018,3,21)),
                new Chicken(LocalDate.of(2000,5,12))
        );
        List<Animal> animals = new ArrayList<>();
        animals.addAll(largeAnimals);
        animals.addAll(smallAnimals);

        Keeper<LargeAnimal> largeAnimalKeeper = new Keeper<>(largeAnimals);
        Keeper<SmallAnimal> smallAnimalKeeper = new Keeper<>(smallAnimals);

        List<Keeper<? extends Animal>> keepers = Arrays.asList(largeAnimalKeeper, smallAnimalKeeper);

        Rabbit babyRabbit = new Rabbit(LocalDate.now());
        smallAnimalKeeper.startLookingAfter(babyRabbit);

        FeedingScheduler feedingScheduler = FeedingScheduler.getInstance();
        GroomingScheduler groomingScheduler = GroomingScheduler.getInstance();
        StrokingScheduler strokingScheduler = StrokingScheduler.getInstance();
        MuckingScheduler muckingScheduler = MuckingScheduler.getInstance();

        feedingScheduler.assignFeedingJobs(keepers);
        groomingScheduler.assignGroomingJobs(keepers);
        strokingScheduler.assignStrokingJobs(keepers);
        muckingScheduler.assignMuckingJobs(keepers);
        animals.forEach(System.out::println);
    }
}
