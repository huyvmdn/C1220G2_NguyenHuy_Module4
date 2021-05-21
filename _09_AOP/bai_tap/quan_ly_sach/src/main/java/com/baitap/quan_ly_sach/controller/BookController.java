package com.baitap.quan_ly_sach.controller;


import com.baitap.quan_ly_sach.Commons.ReadAndWrite;
import com.baitap.quan_ly_sach.entity.Book;
import com.baitap.quan_ly_sach.entity.RentalCode;
import com.baitap.quan_ly_sach.service.BookService;
import com.baitap.quan_ly_sach.service.RentalCodeService;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private RentalCodeService rentalCodeService;





    @GetMapping({"", "/", "/index"})
    public String getIndex(Model model) {
        List<Book> books = (List<Book>) bookService.findAll();
        if (books == null) {
            return "error";
        }
        model.addAttribute("list",books) ;
        int count= ReadAndWrite.readFileListString("count.csv").size();
        model.addAttribute("count",count);
        return "/index";
    }

    @GetMapping("/book/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Book book= bookService.findById(id).get();
        if (book.getStock()<=0) {
            model.addAttribute("object",book );
            model.addAttribute("submit", false);
            return "/view";
        }
        model.addAttribute("submit", true);
        model.addAttribute("object",book);

        model.addAttribute("rentalCode", new RentalCode());

        return "/view";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "idBook", defaultValue = "0") Long id, @RequestParam(value = "idCard", defaultValue = "") String idCard, RedirectAttributes redirect) throws Exception {
        RentalCode rentalCode = new RentalCode(idCard);
        if (idCard.equals("") || (idCard.length()<9)&&idCard.length()>13 || id==0) {
            throw new  Exception("chưa nhập dữ liệu hoặc nhập sai");
        }
        rentalCode.setBook(bookService.findById(id).get());
        String a ;
           boolean check;
           do {
               a= RandomStringUtils.randomAlphanumeric(5);
               check= rentalCodeService.findByCodeRentalCode(a);
                   rentalCode.setCodeRentalCode(a);

           }while (check);

        rentalCodeService.save(rentalCode);
        redirect.addFlashAttribute("mess", "you have borrowed book ");
        return "redirect:/index";
    }

    @GetMapping("/giveBack")
            public String giveBack(){
            return"/giveBack";
            }

            @PostMapping("/giveBack")
            public String giveBack(@RequestParam("id") String rentalCode, RedirectAttributes redirect){
            rentalCodeService.deleteByCodeRentalCode(rentalCode);
            redirect.addFlashAttribute("mess", "you have give back book ");
        return"redirect:/index";
}

}
