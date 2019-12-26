package com.yqq.testWeb.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yanqiangqiang on 2018/12/11.
 */
@Controller
public class TestControler {

    @ResponseBody
    @RequestMapping(value = "t")
    public String test() {

        return "aaaa";

    }

}
