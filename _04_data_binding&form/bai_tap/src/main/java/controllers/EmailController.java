package controllers;


import model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import repisitory.EmailDAO;

import java.util.ArrayList;

@Controller
public class EmailController {



    @GetMapping({"/", "/email"})
    public String email(@ModelAttribute Email email, Model model) {
        model.addAttribute("email",email);
        model.addAttribute("listLanguages", new ArrayList<>( EmailDAO.listLanguages.values()));
        model.addAttribute("listSizePage", EmailDAO.listSizePage);
        return "index";
    }



    @PostMapping("/email")
    public String saveEmail(@ModelAttribute Email email, Model model) {
        model.addAttribute("email",email);

        return "info";
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
