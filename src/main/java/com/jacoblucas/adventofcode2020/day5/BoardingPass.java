package com.jacoblucas.adventofcode2020.day5;

import com.google.common.base.Preconditions;
import org.immutables.value.Value;

import java.util.regex.Pattern;

@Value.Immutable
@Value.Style(allParameters = true)
public abstract class BoardingPass {
    public abstract String getSeatSpec();

    public String getRow() {
        return getSeatSpec().substring(0, 7);
    }

    public String getSeat() {
        return getSeatSpec().substring(7, 10);
    }

    @Value.Check
    public void check() {
        Preconditions.checkArgument(getSeatSpec().length() == 10, "Seat spec must be 10 chars in length");

        final Pattern pattern = Pattern.compile("([FB]){7}([LR]){3}");
        Preconditions.checkArgument(pattern.matcher(getSeatSpec()).matches(), "Seat spec is must 10 chars containing FBLR");
    }
}
