package com.jacoblucas.adventofcode2020.day19;

import org.immutables.value.Value;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Value.Immutable
public abstract class ChoiceRule extends Rule {
    @Override
    public abstract int getId();

    public abstract List<List<Integer>> getChoices();

    @Override
    public String resolvePattern(final Map<Integer, Rule> ruleMap) {
        return "(" + getChoices().stream()
                .map(ids -> ids.stream()
                        .map(id -> ruleMap.get(id).resolvePattern(ruleMap))
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("|")) + ")";
    }
}
