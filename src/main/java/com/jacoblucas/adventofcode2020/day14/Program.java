package com.jacoblucas.adventofcode2020.day14;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Program {
    private static final int BITS = 36;

    private final List<Instruction> instructions;
    private final Map<Long, Long> memory = new HashMap<>();
    private String bitmask = "000000000000000000000000000000000000";
    private int version;

    public Program() {
        this(ImmutableList.of());
    }

    public Program(final List<Instruction> instructions) {
        this.instructions = instructions;
        this.version = 1;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public Map<Long, Long> getMemory() {
        return memory;
    }

    public String getBitmask() {
        return bitmask;
    }

    public void setBitmask(final String bitmask) {
        this.bitmask = bitmask;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    public Optional<Long> read(final long address) {
        return Optional.ofNullable(memory.get(address));
    }

    public void write(final long address, final int value) {
        if (version == 2) {
            decode(address, value);
        } else {
            final char[] bitmaskArr = bitmask.toCharArray();
            final char[] valueArr = toBinaryString(value).toCharArray();
            final char[] result = new char[valueArr.length];
            for (int i = 0; i < valueArr.length; i++) {
                if (bitmaskArr[i] == 'X') {
                    result[i] = valueArr[i];
                } else {
                    result[i] = bitmaskArr[i];
                }
            }
            memory.put(address, Long.parseLong(new String(result), 2));
        }
    }

    public void execute() {
        instructions.forEach(i -> i.set(this));
    }

    public void decode(final long address, final int value) {
        final List<String> addresses = applyMask(toBinaryString(address), 0);
        addresses.forEach(addr -> memory.put(Long.parseLong(addr, 2), (long) value));
    }

    private ArrayList<String> applyMask(String address, final int index) {
        if (index == address.length()) {
            ArrayList<String> solution = new ArrayList<>();
            solution.add(address);
            return solution;
        } else if (bitmask.charAt(index) == '1') {
            address = address.substring(0, index) + bitmask.charAt(index) + address.substring(index + 1);
            return applyMask(address, index + 1);
        } else if (bitmask.charAt(index) == 'X') {
            address = address.substring(0, index) + "1" + address.substring(index + 1);
            final ArrayList<String> a = applyMask(address, index + 1);
            address = address.substring(0, index) + "0" + address.substring(index + 1);
            final ArrayList<String> b = applyMask(address, index + 1);
            a.addAll(b);
            return a;
        } else {
            return applyMask(address, index + 1);
        }
    }

    public static String toBinaryString(final long n) {
        return StringUtils.leftPad(Long.toBinaryString(n), BITS, '0');
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
