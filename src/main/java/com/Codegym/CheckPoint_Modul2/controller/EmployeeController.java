package com.Codegym.CheckPoint_Modul2.controller;

import com.Codegym.CheckPoint_Modul2.model.Category;
import com.Codegym.CheckPoint_Modul2.model.Employee;
import com.Codegym.CheckPoint_Modul2.service.CategoryService;
import com.Codegym.CheckPoint_Modul2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService<Employee> employeeEmployeeService;
    @Autowired
    private CategoryService<Category> categoryCategoryService;


    @ModelAttribute("categories")
    public Iterable<Category> getCategory(){
        return categoryCategoryService.findAll();
    }

    @GetMapping("/create-employee")
    public ModelAndView createEmployee(){
        ModelAndView modelAndView = new ModelAndView("something/create");
        modelAndView.addObject("employee",new Employee());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public String createBlog(Employee employee){
        employeeEmployeeService.save(employee);
        return ("redirect:/home");
    }

    @GetMapping("/update_employee/{id}")
    public ModelAndView updateCategory(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("something/update");
        modelAndView.addObject("employee", (Employee)employeeEmployeeService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update_employee")
    public String updateCategory(Employee employee) {
        employeeEmployeeService.save(employee);
        return "redirect:/home";
    }

    @GetMapping("/delete_employee/{id}")
    public String deleteCategory(@PathVariable Long id) {
        if (employeeEmployeeService.findById(id)==null){
            return "redirect:/error-404";
        }else {
            employeeEmployeeService.remove(id);
            return "redirect:/home";
        }


    }
}
