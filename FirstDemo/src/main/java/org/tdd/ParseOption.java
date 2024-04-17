package org.tdd;

import java.util.List;

interface ParseOption {
    Object parseOption(List<String> argList, Option option);
}
