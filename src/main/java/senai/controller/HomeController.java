package senai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/mensagem")
    public ModelAndView mensagem() {
        ModelAndView modelAndView = new ModelAndView("mensagem");
        modelAndView.setViewName("mensagem");
        modelAndView.addObject("mensagem", "Servidor, me responda! Houston, temos um problema!");
        return modelAndView;
    }

    @GetMapping("/saudacao")
    public ModelAndView saudacao() {
        ModelAndView modelAndView = new ModelAndView("saudacao");
        modelAndView.setViewName("saudacao");
        modelAndView.addObject("saudacao", "Olá, seja bem-vindo ao Spring Boot!");
        return modelAndView;
    }

}
