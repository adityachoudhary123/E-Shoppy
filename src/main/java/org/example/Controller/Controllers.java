package org.example.Controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controllers {

    @RequestMapping("/home")
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @RequestMapping("/register")
    public ModelAndView register()
    {
        ModelAndView mv = new ModelAndView("register");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login()
    {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping("/search")
    public ModelAndView search()
    {
        ModelAndView mv = new ModelAndView("search");
        return mv;
    }

    @RequestMapping("/carts")
    public  ModelAndView cart()
    {
        ModelAndView mv = new ModelAndView("carts");
        return mv;
    }
}
