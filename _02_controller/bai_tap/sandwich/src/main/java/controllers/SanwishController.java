package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SanwishController {

    @GetMapping("/")
    public String getindex() {
        return "index";
    }

    @GetMapping("/giaVi")
    public String save(@RequestParam("giaVi") String[] condiment, Model model) {
        model.addAttribute("mangGiaVi",condiment);
           return "index";
    }

}
