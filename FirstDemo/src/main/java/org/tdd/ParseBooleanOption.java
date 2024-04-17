package org.tdd;

import java.util.List;

class ParseBooleanOption implements ParseOption {
    @Override
    public Object parseOption(List<String> argList, Option option) {
        return argList.contains("-" + option.value());
    }
}
