/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hundsun.study.spring.springjson;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author zhouxh
 */
@Controller("springJsonHello")
public class SpringJsonHelloController {

    private static final Log log = LogFactory.getLog(SpringJsonHelloController.class);

    @RequestMapping("/sayHello.json")
    public ModelAndView sayHello(){
        log.info("Hello");
        ModelAndView modelAndView = new ModelAndView("jsonView");
        modelAndView.addObject("Hello");
        modelAndView.addObject("success",true);
        List<Hello> helloList = new ArrayList<Hello>();
        for(int i=0; i<4; i++){
        	Hello hello = new Hello();
        	hello.setName("HelloName" + i);
        	hello.setSex(i%2 == 1);
        	helloList.add(hello);
        	log.info(hello.toStirng());
        }
        modelAndView.addObject("helloList",helloList);
        return modelAndView;
    }
}
