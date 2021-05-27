package com.case_study.furama.controller;



import com.case_study.furama.dto.EmployeeDTO;
import com.case_study.furama.dto.Mapping;
import com.case_study.furama.model.Role;
import com.case_study.furama.model.User;
import com.case_study.furama.model.entity.Division;
import com.case_study.furama.model.entity.EducationDegree;
import com.case_study.furama.model.entity.Employee;
import com.case_study.furama.model.entity.Position;
import com.case_study.furama.service.*;
import com.case_study.furama.ultil.EncrypPasswordUtils;
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

    @GetMapping("/employee/edit/{id}")
    public String editObject(@PathVariable Long id, Model model) {
        model.addAttribute("object", employeeService.findById(id).get());
        return "/employee/update";
    }


    @PostMapping("/employee/update")
    public String update(@Valid @ModelAttribute("object") EmployeeDTO object, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "/employee/update";
        }
        String role ;
        String role2;
        HashSet<Role> roles = new HashSet<>();
        if ( "Director".equals(object.getPosition().getName()) || "Manager".equals(object.getPosition().getName()) ) {
            role= "ROLE_MEMBER";
            role2="ROLE_ADMIN";
            roles.add(roleService.findByName(role));
            roles.add(roleService.findByName(role2));
        } else {
            role="ROLE_MEMBER";
            roles.add(roleService.findByName(role));
        }

        Employee employee= Mapping.dtoToEmployee(object);
        User user = new User();
        user.setEmail(employee.getEmail());
        user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));

        user.setRoles(roles);
        userService.save(user);
        employee.setUser(user);
        employeeService.save(employee);
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
            String role ;
        HashSet<Role> roles = new HashSet<>();
        if ( "Director".equals(object.getPosition().getName()) || "Manager".equals(object.getPosition().getName()) ) {
            role= "ROLE_ADMIN";
        } else {
            role="ROLE_MEMBER";
        }
        roles.add(roleService.findByName(role));
        User user = new User();
        user.setEmail(object.getEmail());
        user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils("123456"));
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

    @GetMapping("/employee/search")
    public String search(@RequestParam(value = "nameEmployee", defaultValue = "") String nameEmployee,
                         @RequestParam(value = "position", defaultValue = "") String position,
                         @RequestParam(value = "educationDegree", defaultValue = "") String educationDegree,
                         @RequestParam(value = "division", defaultValue = "") String division,

                         @PageableDefault(value = 5) Pageable pageable,
                         Model model) {

        model.addAttribute("list", employeeService.search4(nameEmployee, position, educationDegree,division,pageable));
        model.addAttribute("nameEmployee", nameEmployee);
        model.addAttribute("position", position);
        model.addAttribute("educationDegree", educationDegree);
        model.addAttribute("division", division);
        return "/employee/employee";
    }

}

