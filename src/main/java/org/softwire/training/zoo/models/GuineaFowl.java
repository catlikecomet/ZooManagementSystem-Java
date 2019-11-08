package org.softwire.training.zoo.models;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class GuineaFowl extends AbstractAnimal implements SmallAnimal, CanBeStroked {

    private LocalDateTime lastStroked;
    public GuineaFowl(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    @Override
    public void feed() {
        System.out.println("<peck>");
        super.feed();
    }

    @Override
    public void stroke(){
        lastStroked = LocalDateTime.now();
    }

    @Override
    public String toString(){
        return MessageFormat.format("{0}; Last Stroked {1}", super.toString(),lastStroked);
    }
}



