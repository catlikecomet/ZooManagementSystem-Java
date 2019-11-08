package org.softwire.training.zoo.models;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SnowLeopard extends AbstractAnimal implements LargeAnimal, CanBeStroked {

    private LocalDateTime lastStroked;

    public SnowLeopard(LocalDate dateOfBirth) {
        super(dateOfBirth);
    }

    @Override
    public void feed(){
        System.out.println("<Purrs>");
        super.feed();
    }

    @Override
    public void stroke(){
        lastStroked = LocalDateTime.now();
    }

    @Override
    public String toString(){
        return MessageFormat.format("{0}; Last Stroked {1}", super.toString(), lastStroked);
    }


}
