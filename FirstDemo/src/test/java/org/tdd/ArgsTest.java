package org.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArgsTest {

    /**
     * 先大致构想一下接口应该如何被调用，也就是思考这段代码如何会被用户去使用
     * 这里测试主要就是加入我们的代码功能已经实现了，如何使用？
     * <p>
     * 接下来看看输入，然后思考我们应该怎么解决，输入是 -l -p 8080 -d /usr/logs，我们应该怎么解析？
     * 解析的方法有很多，选择一个就可以，比如说直接使用字符串分割，结果就是：[-l], [-p, 8080], [-d, /usr/logs]
     * 也可以使用 String 和 Array 的 Map，转化结果为：{-l: []}, {p: [8080[}, {d: [/usr/logs]}
     * 这里采用索引的方式来处理吧
     * <p>
     * 功能分解和任务列表，两个例子分别是 -l -p 8080 -d /usr/logs　和 -g this is a list -d 1 2 -3 5
     * 将功能转化为 todo list，然后逐个实现，最后再测试一下是否符合预期
     * 1. 解析 bool
     * 2. 解析 int
     * 3. 解析 string
     * 4. 解析 string 数组
     * 5. 解析 整形数组
     * 6. bool 错误输入的情况
     * 7. int 错误输入的情况
     * 8. string 错误输入的情况
     * 9. bool 默认值的返回
     * 10. int 默认值的返回
     * 11. string 默认值的返回
     * 12. 多个参数的情况
     */

    // 解析 bool，快速失败以及快速成功
    @Test
    void testParseBoolFalseIfPresent() {
        BoolRecord parse = Args.parse(BoolRecord.class, "-l");
        assertTrue(parse.logging());
    }

    // 上一个测试的相反 case
    @Test
    void testParseBoolFalseIfNotPresent() {
        BoolRecord parse = Args.parse(BoolRecord.class);
        assertFalse(parse.logging());
    }
    record BoolRecord(@Option("-l") boolean logging) {
    }


    @Test
    @Disabled
    void testFirstDemo() {
        // 解析命令行参数
        OptionRecord optionRecord = Args. parse(OptionRecord.class, "-l");
    }

    record OptionRecord(@Option("-l") boolean logging, @Option("-p") int port, @Option("-d") String directory) {
    }
}
