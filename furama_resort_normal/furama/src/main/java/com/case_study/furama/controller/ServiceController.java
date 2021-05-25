package com.case_study.furama.controller;




import com.case_study.furama.model.entity.EntityService;
import com.case_study.furama.model.entity.RentType;
import com.case_study.furama.model.entity.ServiceType;
import com.case_study.furama.service.RentTypeService;
import com.case_study.furama.service.ServiceService;
import com.case_study.furama.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;


    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private RentTypeService rentTypeService;

    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> serviceTypes() {
        return serviceTypeService.findAll();
    }
    @ModelAttribute("rentTypes")
    public Iterable<RentType> rentTypes() {
        return rentTypeService.findAll();
    }


    @GetMapping({"/service/service"})
    public ModelAndView getIndex(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/service/service");
        Page<EntityService> list =  serviceService.findAll(pageable);
        if (list==null) {
            return new ModelAndView("/authentication/error");
        }
        modelAndView.addObject("list",list);
        return modelAndView;
    }


    @GetMapping("service/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("object", serviceService.findById(id).get());
        return "service/update";
    }

    @PostMapping("service/update")
    public String update(@Valid @ModelAttribute("object") EntityService object, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "/service/update";
        }
        serviceService.save(object);
        redirect.addFlashAttribute("mess", object.getId()+"updated successfully");
        return "redirect:/service/service";
    }


    @GetMapping("/service/create")
    public String create(Model model) {
        model.addAttribute("object", new EntityService());
        return "/service/create";
    }


    @PostMapping("/service/save")
    public String save(@Valid  @ModelAttribute("object") EntityService object, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "/service/create";
        }

        serviceService.save(object);
        redirect.addFlashAttribute("mess",object.getId()+" "+object.getName()+" created successfully");
        return "redirect:/service/service";
    }

    @PostMapping("/service/delete")
    public String delete(@RequestParam("idDelete") Long idDelete, Model model) {
        serviceService.deleteById(idDelete);
        model.addAttribute("mess", " delete successfully");
        return "redirect:/service/service";
    }

}
