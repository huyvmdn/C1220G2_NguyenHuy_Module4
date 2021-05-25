package com.case_study.furama.controller;



import com.case_study.furama.model.entity.AttachService;
import com.case_study.furama.model.entity.Contract;
import com.case_study.furama.model.entity.ContractDetail;
import com.case_study.furama.service.AttachServiceService;
import com.case_study.furama.service.ContractDetailService;
import com.case_study.furama.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private AttachServiceService attachServiceService;

    @ModelAttribute("contracts")
    public Iterable<Contract> contracts() {
        return contractService.findAll();
    }

    @ModelAttribute("attachServices")
    public Iterable<AttachService> attachServices() {
        return attachServiceService.findAll();
    }

    @GetMapping("/contractDetail/view/{id}")
    public String show(@PathVariable("id") Long id  , Model model) {
        Contract contract = contractService.findById(id).orElse(null);
        if (contract == null) {
            return "authentication/error";
        }
        model.addAttribute("object", contract);
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



    @GetMapping("contractDetail/edit/{id}")
    public String editObject(@PathVariable Long id, Model model) {
         ContractDetail contractDetail=  contractDetailService.findById(id).orElse(null);
        if (contractDetail==null) {
            model.addAttribute("mess", "đối tượng có id "+ id + "null");
            return "/authentication/error";
        }
        model.addAttribute("object", contractDetail);
        return "contract/update";
    }

    @PostMapping("contractDetail/update")
    public String updateObject(@Valid  @ModelAttribute("object") ContractDetail object, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "/contractDetail/update";
        }
        contractDetailService.save(object);
        redirect.addFlashAttribute("mess", object.getId()+"updated successfully");
        return "redirect:/contractDetail/contract";
    }

}
