package com.jacoblucas.adventofcode2020.day19;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MessageValidator {
    private final Map<Integer, Rule> rules;

    public MessageValidator(final Map<Integer, Rule> rules) {
        this.rules = rules;
    }

    public List<String> match(final int ruleId, final List<String> messages) {
        final String pattern = resolve(ruleId);
        return match(Pattern.compile(pattern), messages);
    }

    public String resolve(final int id) {
        return "^" + rules.get(id).resolvePattern(rules) + "$";
    }

    public List<String> match(final Pattern pattern, final List<String> messages) {
        return messages.stream()
                .filter(msg -> pattern.matcher(msg).matches())
                .collect(Collectors.toList());
    }
}
