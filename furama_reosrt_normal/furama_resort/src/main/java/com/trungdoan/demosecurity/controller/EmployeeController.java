package com.trungdoan.demosecurity.controller;


import com.trungdoan.demosecurity.model.Role;
import com.trungdoan.demosecurity.model.User;
import com.trungdoan.demosecurity.model.entity.*;
import com.trungdoan.demosecurity.service.*;
import com.trungdoan.demosecurity.ultil.EncrypPasswordUtils;
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
import java.util.HashSet;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private EducationDegreesService educationDegreesService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @ModelAttribute("positions")
    public Iterable<Position> positions() {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public Iterable<EducationDegree> educationDegrees() {
        return educationDegreesService.findAll();
    }

    @ModelAttribute("divisions")
    public Iterable<Division> divisions() {
        return divisionService.findAll();
    }



    @GetMapping({"/employee/employee"})
    public ModelAndView getIndex(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/employee/employee");
        Page<Employee> list = employeeService.findAll(pageable);
        if (list == null) {
            return new ModelAndView("/authentication/403");
        }
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("employee/edit/{id}")
    public String editObject(@PathVariable Long id, Model model) {
        model.addAttribute("object", employeeService.findById(id).get());
        return "employee/update";
    }



    @PostMapping("employee/update")
    public String updateObject(@Valid @ModelAttribute("object") Employee object, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "/employee/update";
        }
        employeeService.save(object);
        redirect.addFlashAttribute("mess", object.getId()+"updated successfully");
        return "redirect:/employee/employee";
    }


    @GetMapping("/employee/create")
    public String create(Model model) {
        model.addAttribute("object", new Employee());
        return "/employee/create";
    }


    @PostMapping("/employee/save")
    public String save(@Valid  @ModelAttribute("object") Employee object, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "/employee/create";
        }
        User user = new User();
        user.setEmail(object.getEmail());
        user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleService.findByName("ROLE_MEMBER"));
        user.setRoles(roles);
        userService.save(user);
        object.setUser(user);
        employeeService.save(object);
        redirect.addFlashAttribute("mess",object.getId()+" "+object.getName()+" created successfully");
        return "redirect:/employee/employee";
    }

    @PostMapping("/employee/delete")
    public String delete(@RequestParam("idDelete") Long idDelete, Model model) {
        employeeService.deleteById(idDelete);
        model.addAttribute("mess", " delete successfully");
        return "redirect:/employee/employee";
    }


}

