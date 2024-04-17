package org.tdd;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author wangzhi
 */
public class Args {

    public static <T> T parse(Class<T> optionRecordClass, String... args) {
        try {
            List<String> argList = Arrays.asList(args);

            Constructor<?> constructor = optionRecordClass.getDeclaredConstructors()[0];

            Object[] values =
                Arrays.stream(constructor.getParameters()).map(p -> parseSingleOption(p, argList)).toArray();

            return (T)constructor.newInstance(values);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object parseSingleOption(Parameter parameter, List<String> argList) {
        return PARSE_OPTION_FACTORY.get(parameter.getType())
            .parseOption(argList, parameter.getAnnotation(Option.class));
    }

    private static final Map<Class<?>, ParseOption> PARSE_OPTION_FACTORY = Map.of(
            boolean.class, new ParseBooleanOption(),
            int.class, new ParseSingleValueOption<>(Integer::valueOf),
            String.class, new ParseSingleValueOption<>(String::valueOf));

}
