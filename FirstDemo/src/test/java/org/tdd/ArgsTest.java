package org.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class ArgsTest {

    /**
     * 先大致构想一下接口应该如何被调用，也就是思考这段代码如何会被用户去使用
     * 这里测试主要就是加入我们的代码功能已经实现了，如何使用
     */
    @Test
    @Disabled
    void testFirstDemo() {
        // 解析命令行参数
        OptionRecord optionRecord = Args.parse(OptionRecord.class, "-l", "-p", "8080", "-d", "/usr/logs");
        // 读取解析出来的指令，进行断言处理
        optionRecord.logging();
        optionRecord.port();

    }

    static record OptionRecord(@Option("-l") boolean logging, @Option("-p") int port, @Option("-d") String directory) {
    }
}
