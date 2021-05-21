package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Caculator {

    @GetMapping("/phepTinh")
    public String tinhKetQua(@RequestParam(defaultValue = "0") Double so1, @RequestParam(defaultValue = "0" ) Double so2, @RequestParam String phepTinh, Model model) {

        double ketQua= 0;
        switch (phepTinh) {
            case "+":
                ketQua=so1+so2;
                break;
            case "-":
                ketQua=so1-so2;
                break;
            case "*":
                ketQua=so1*so2;
                break;
            case "/":
                ketQua=so1/so2;

                break;
            default:
        }


       if (so2==0 && phepTinh.equals("/")) {
           model.addAttribute("ketQua","ban dang nhap so ngu");
       } else{
           model.addAttribute("ketQua",ketQua);
       }
        return "index";
    }

    @GetMapping
    public String getIndex() {
        return "index";
    }
}
