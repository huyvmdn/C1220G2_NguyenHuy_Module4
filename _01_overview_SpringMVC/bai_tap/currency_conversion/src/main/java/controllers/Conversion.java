package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Conversion {
    @PostMapping("/conversion")
    public String conversion (@RequestParam String tien, Model model) {
        Double ketqua= Double.parseDouble(tien) *22000;
        model.addAttribute("ketqua", ketqua);
        return "index";
    }
@GetMapping("/")
    public String getindex() {
     return "index";
    }

}
