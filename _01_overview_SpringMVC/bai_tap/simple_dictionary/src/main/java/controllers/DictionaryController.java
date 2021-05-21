package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ripository.DictionaryDAO;
import service.DictionaryService;


@Controller
public class DictionaryController {
    @PostMapping("/dictionary")
    public String dictionary (@RequestParam String ma, Model model) {
        String ketqua= DictionaryService.search(ma);
        model.addAttribute("ketqua", ketqua);
        return "index";
    }

    @GetMapping("/")
    public String getindex() {
        return "index";
    }

}
