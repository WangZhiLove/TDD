package org.tdd;

import java.util.List;
import java.util.function.Function;

class ParseSingleValueOption<T> implements ParseOption {

    private final Function<String, T> parseFunc;

    public ParseSingleValueOption(Function<String, T> parseFunc) {
        this.parseFunc = parseFunc;
    }

    @Override
    public Object parseOption(List<String> argList, Option option) {
        return parseFunc.apply(argList.get(argList.indexOf("-" + option.value()) + 1));
    }
}
