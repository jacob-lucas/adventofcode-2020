package com.jacoblucas.adventofcode2020.day5;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BoardingPassTest {
    @Test(expected = IllegalArgumentException.class)
    public void testInvalid() {
        ImmutableBoardingPass.builder()
                .seatSpec("FBF")
                .build();
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLetters() {
        ImmutableBoardingPass.builder()
                .seatSpec("ABCDEFGHIJ")
                .build();
    }

    @Test
    public void testGetRow() {
        final BoardingPass boardingPass = ImmutableBoardingPass.builder()
                .seatSpec("FBFBBFFRLR")
                .build();

        assertThat(boardingPass.getRow(), is("FBFBBFF"));
    }

    @Test
    public void testGetSeat() {
        final BoardingPass boardingPass = ImmutableBoardingPass.builder()
                .seatSpec("FBFBBFFRLR")
                .build();

        assertThat(boardingPass.getSeat(), is("RLR"));
    }
}
