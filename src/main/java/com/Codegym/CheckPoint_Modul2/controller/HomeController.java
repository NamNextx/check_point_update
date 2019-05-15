package com.Codegym.CheckPoint_Modul2.controller;

import com.Codegym.CheckPoint_Modul2.model.Category;
import com.Codegym.CheckPoint_Modul2.model.Employee;
import com.Codegym.CheckPoint_Modul2.service.CategoryService;
import com.Codegym.CheckPoint_Modul2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private EmployeeService<Employee> someThingEmployeeService;

    @Autowired
    private CategoryService<Category> categoryCategoryService;

    @ModelAttribute("listEmployee")
    public Iterable<Employee> findAllCategory(){
        return someThingEmployeeService.findAll();
    }

    @GetMapping("/home")
    public ModelAndView listBlog(@RequestParam("s") Optional<String> s, @PageableDefault(5) Pageable pageable) {
        Page<Employee> employeePage;
        if(s.isPresent()){
            employeePage = someThingEmployeeService.findAllByGenContainingOrNameContaining(s.get(),s.get(),pageable);
        }else {
            employeePage = someThingEmployeeService.findAll(pageable);
        }
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("employees",employeePage);
        return modelAndView;
    }
}
