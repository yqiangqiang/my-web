package com.yqq.spi;

import com.yqq.dubbo.spi.Robot;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

public class DubboSPITest {

    @Test
    public void sayHello() {

        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();

    }

}
