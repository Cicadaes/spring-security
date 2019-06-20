package com.auth.center.springsecurity.controller;

import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: <br>
 * Function: <br>
 * date: 2019-06-04 15:48<br>
 * @author liqiangqiang<br>
 * @version
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "/map")
public class MapController {

    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(@NotNull @RequestParam String keyword,Model model) {
        model.addAttribute("keyword", keyword);
        return "index";
    }
    /**
     * Model本身不能设置页面跳转的url地址别名或者物理跳转地址，那么我们可以通过控制器方法的返回值来设置跳转url
     * 地址别名或者物理跳转地址
     *
     * @param model
     *            一个接口， 其实现类为ExtendedModelMap，继承了ModelMap类
     * @return 跳转url地址别名或者物理跳转地址
     */
    @RequestMapping(value = "/index1")
    public String index1(Model model) {
        model.addAttribute("result", "后台返回index1");
        return "result";
    }

    /**
     * ModelMap对象主要用于传递控制方法处理数据到结果页面,类似于request对象的setAttribute方法的作用。 用法等同于Model
     *
     * @param model
     * @return 跳转url地址别名或者物理跳转地址
     */

    @RequestMapping(value = "/index2")
    public String index2(ModelMap model) {
        model.addAttribute("result", "后台返回index2");
        return "result";
    }

    /**
     * ModelAndView主要有两个作用 设置转向地址和传递控制方法处理结果数据到结果页面
     * @return 返回一个模板视图对象
     */
    @RequestMapping(value = "/index3")
    public ModelAndView index3() {
        ModelAndView mv = new ModelAndView("result");
        // ModelAndView mv = new ModelAndView();
        // mv.setViewName("result");
        mv.addObject("result", "后台返回index3");
        return mv;
    }

    /**
     * map用来存储递控制方法处理结果数据，通过ModelAndView方法返回。
     * 当然Model,ModelMap也可以通过这种方法返回
     * @return 返回一个模板视图对象
     */
    @RequestMapping(value = "/index4")
    public ModelAndView index4() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", "后台返回index4");
        return new ModelAndView("result", map);
    }
}