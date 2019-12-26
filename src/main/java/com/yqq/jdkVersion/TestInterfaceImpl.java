package com.yqq.jdkVersion;

/**
 * Created by yanqiangqiang on 2018/12/4.
 */
public class TestInterfaceImpl implements TestInterface {

    public String test() {
        return "bbb";
    }

    @Override
    public int test2() {
        return 222;
    }
}
