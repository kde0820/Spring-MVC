package controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import user.User;
import user.UserValidator;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/request/requestTest")
    public String requestTest(HttpServletRequest httpServletRequest, Model model){
        String id = httpServletRequest.getParameter("id");
        String name = httpServletRequest.getParameter("name");

        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "/request/requestTest";
    }

    @RequestMapping(value = "/request/paramTest")
    public String paramTest(@RequestParam("id") String id, @RequestParam("name") String name, Model model){
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "/request/paramTest";
    }

    @RequestMapping(value = "/user/userTest")
    public String userTest(User user){

        return "/user/userTest";
    }

    @RequestMapping(method = RequestMethod.POST, value = "join")
    public String join(User user){
        return "/user/userTest";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/userConfirm")
    public String userConfirm(User user){
        if(user.getId().equals("test")){
            return "redirect:userSuccess";
        }
        return "redirect:userError";
    }

    @RequestMapping(value = "/user/userSuccess")
    public String userSuccess(){
        return "/user/userSuccess";
    }

    @RequestMapping(value = "/user/userError")
    public String userError(){
        return "/user/userError";
    }

    @RequestMapping(value = "/validationForm")
    public String validationForm(){
        return "/validation/validationForm";
    }

    @RequestMapping(value = "/validation/check")
    public String validationCheck(User user, BindingResult result){
        String page = "/validation/checkDoneUser";

        UserValidator validator = new UserValidator();
        validator.validate(user, result);
        if(result.hasErrors()){
            page = "/validation/validationForm";
        }

        return page;
    }

}
