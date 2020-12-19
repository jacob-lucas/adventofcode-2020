package com.jacoblucas.adventofcode2020.day19;

import org.immutables.value.Value;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Value.Immutable
public abstract class ListRule extends Rule {
    @Override
    public abstract int getId();

    public abstract List<Integer> getRuleIds();

    @Override
    public String resolvePattern(final Map<Integer, Rule> ruleMap) {
        return getRuleIds().stream()
                .map(ruleMap::get)
                .map(r -> r.resolvePattern(ruleMap))
                .collect(Collectors.joining());
    }
}
