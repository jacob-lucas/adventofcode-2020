package com.jacoblucas.adventofcode2020.day14;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Program {
    private static final int BITS = 36;

    private final List<Instruction> instructions;
    private final Map<Integer, Long> memory = new HashMap<>();
    private String bitmask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    public Program() {
        this(ImmutableList.of());
    }

    public Program(final List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public Map<Integer, Long> getMemory() {
        return memory;
    }

    public String getBitmask() {
        return bitmask;
    }

    public void setBitmask(final String bitmask) {
        this.bitmask = bitmask;
    }

    public Optional<Long> read(final int address) {
        return Optional.ofNullable(memory.get(address));
    }

    public void write(final int address, final int value) {
        final char[] bitmaskArr = bitmask.toCharArray();
        final char[] valueArr = toBinaryString(value).toCharArray();
        final char[] result = new char[valueArr.length];
        for (int i=0; i<valueArr.length; i++) {
            if (bitmaskArr[i] == 'X') {
                result[i] = valueArr[i];
            } else {
                result[i] = bitmaskArr[i];
            }
        }
        memory.put(address, Long.parseLong(new String(result), 2));
    }

    public void execute() {
        instructions.forEach(i -> i.set(this));
    }

    public static String toBinaryString(final int n) {
        return StringUtils.leftPad(Integer.toBinaryString(n), BITS, '0');
    }

    public static Program parse(final List<String> input) {
        final List<Instruction> instructions = input.stream()
                .map(str -> {
                    final String[] parts = str.split(" = ");
                    if (parts[0].equals("mask")) {
                        return ImmutableBitmaskInstruction.of(parts[1]);
                    } else {
                        return ImmutableMemoryInstruction.of(
                                Integer.parseInt(parts[0].substring(4, parts[0].length() - 1)),
                                Integer.parseInt(parts[1]));
                    }
                })
                .collect(Collectors.toList());

        return new Program(instructions);
    }
}
