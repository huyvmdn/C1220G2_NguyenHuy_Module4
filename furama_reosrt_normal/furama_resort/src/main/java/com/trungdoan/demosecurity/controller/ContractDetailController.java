package com.trungdoan.demosecurity.controller;

import com.trungdoan.demosecurity.model.entity.Contract;
import com.trungdoan.demosecurity.model.entity.ContractDetail;
import com.trungdoan.demosecurity.model.entity.Customer;
import com.trungdoan.demosecurity.service.ContractDetailService;
import com.trungdoan.demosecurity.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ContractDetailController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractDetailService contractDetailService;

    @GetMapping("/contractDetail/view/{id}")
    public String show(@PathVariable("id") Long id  , Model model) {
        Contract contract = contractService.findById(id).get();
        if (contract == null) {
            model.addAttribute("object", new ContractDetail());
            return "/contractDetail/view";
        }
        model.addAttribute("object", new ContractDetail());
        model.addAttribute("contract", contract);
        return "/contractDetail/view";
    }

    @GetMapping("contractDetail/create" )
    public String create(Model model) {
        model.addAttribute("object", new ContractDetail());
        return "/contractDetail/create";
    }

    @GetMapping("contractDetail/create/{id}" )
    public String create(@ModelAttribute("id")Long  id, Model model) {
        Contract contract = contractService.findById(id).get();
        if (contract == null) {
            model.addAttribute("object",new ContractDetail());
            return "/contractDetail/create";
        }
        model.addAttribute("object",new ContractDetail());
        model.addAttribute("contract",contract);
        return "/contractDetail/create";
    }

    @PostMapping("/contractDetail/save")
    public String save(@Valid @ModelAttribute("object") ContractDetail object, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "/contractDetail/create";
        }
        contractDetailService.save(object);
        redirect.addFlashAttribute("mess","Contract "+object.getId()+" created successfully");
        return "redirect:/contract/contract";
    }


    @PostMapping("/contractDetail/delete")
    public String delete(@RequestParam("idDelete") Long idDelete, Model model) {
        contractDetailService.deleteById(idDelete);
        model.addAttribute("mess", " delete successfully");
        return "redirect:/contract/contract" ;
    }

}
