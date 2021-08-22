package com.sh.config;

import com.sun.beans.editors.IntegerEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SpringControllerAdvice {

    /**
     * 应用到所有被@RequestMapping注解的方法，在其初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
        String username = request.getParameter("username");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),true));
        binder.registerCustomEditor(int.class, new IntegerEditor());
        System.out.println("执行 SpringControllerAdvice initBinder >>>>>>>" + username);
    }

    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("word","hello world");
        System.out.println("执行 SpringControllerAdvice addAttribute >>>>>>>");
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception e){
        System.out.println("执行 SpringControllerAdvice errorHandler >>>>>>>");
        System.out.println(e.getMessage());
        Map<String,Object> result = new HashMap<>();
        result.put("word", e.getMessage());
        return result;
    }

}
