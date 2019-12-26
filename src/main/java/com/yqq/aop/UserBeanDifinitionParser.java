package com.yqq.aop;

import com.yqq.entity.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class UserBeanDifinitionParser extends AbstractSingleBeanDefinitionParser {

    protected Class getBeanClass(Element element) {
        return User.class;

    }

    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String userName = element.getAttribute("userName");
        String password = element.getAttribute("password");

        if (StringUtils.hasText(userName)) {
            builder.addPropertyValue("userName", userName);
        }
        if (StringUtils.hasText(password)) {
            builder.addPropertyValue("password", password);
        }

    }


}
