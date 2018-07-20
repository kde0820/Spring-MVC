package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/model/modelTest")
    public String modelTest(Model model){
        model.addAttribute("data", "Test Data");
        return "/model/modelTest";
    }

    @RequestMapping(value = "/model/modelAndView")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id","Test ID");
        modelAndView.setViewName("/model/modelAndView");

        return modelAndView;
    }
}
