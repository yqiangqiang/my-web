package com.yqq.jdkVersion;

/**
 * Created by yanqiangqiang on 2018/12/4.
 */
public interface TestInterface {

    default String test() {
        return "aaa";
    }

    public int test2();

}
