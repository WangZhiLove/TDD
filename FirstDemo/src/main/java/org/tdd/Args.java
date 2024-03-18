package org.tdd;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangzhi
 */
public class Args {

    public static <T> T parse(Class<T> optionRecordClass, String... args) {
        try {
            Constructor<?> constructor = optionRecordClass.getDeclaredConstructors()[0];
            Parameter parameter = constructor.getParameters()[0];
            Option option = parameter.getAnnotation(Option.class);
            List<String> argList = Arrays.asList(args);
            return (T) constructor.newInstance(argList.contains(option.value()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
