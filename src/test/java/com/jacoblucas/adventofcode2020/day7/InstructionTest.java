package com.jacoblucas.adventofcode2020.day7;

import com.jacoblucas.adventofcode2020.day8.ImmutableInstruction;
import com.jacoblucas.adventofcode2020.day8.Instruction;
import com.jacoblucas.adventofcode2020.day8.Operation;
import io.vavr.control.Try;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InstructionTest {
    @Test
    public void nop() {
        final Try<Instruction> instruction = Instruction.parse("nop +0");
        assertThat(instruction.isSuccess(), is(true));
        assertThat(instruction.get(), is(ImmutableInstruction.builder()
                .operation(Operation.NOP)
                .argument(0)
                .build()));
    }

    @Test
    public void acc() {
        final Try<Instruction> instruction = Instruction.parse("acc -99");
        assertThat(instruction.isSuccess(), is(true));
        assertThat(instruction.get(), is(ImmutableInstruction.builder()
                .operation(Operation.ACC)
                .argument(-99)
                .build()));
    }

    @Test
    public void jmp() {
        final Try<Instruction> instruction = Instruction.parse("jmp +4");
        assertThat(instruction.isSuccess(), is(true));
        assertThat(instruction.get(), is(ImmutableInstruction.builder()
                .operation(Operation.JMP)
                .argument(4)
                .build()));

    }
}
