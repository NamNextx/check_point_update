package com.Codegym.CheckPoint_Modul2.controller;


import com.Codegym.CheckPoint_Modul2.model.Category;
import com.Codegym.CheckPoint_Modul2.model.Employee;
import com.Codegym.CheckPoint_Modul2.service.CategoryService;
import com.Codegym.CheckPoint_Modul2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
    public class RestController {

    @Autowired
    private CategoryService<Category> categoryService;

    @Autowired
    private EmployeeService<Employee> employeeService;


    //-------------------Get list Category--------------------------------------------------------
    @RequestMapping(value = "/list-category", method = RequestMethod.GET)
    public ResponseEntity< List<Category> > listAllCategory() {
        List<Category> categoryList = (List<Category>) categoryService.findAll();
        boolean flag = false;

        for (Category note : categoryList
        ) {
            if (note.getEmployeeList() == null || categoryList.isEmpty()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
        } else return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
    }

    //-------------------Create a Category--------------------------------------------------------
    @RequestMapping(value = "/create-category", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCustomer(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
        categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Update a Category--------------------------------------------------------
    @RequestMapping(value = "/category-update/{id}", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> updateCustomer(@PathVariable("id") long id, @RequestBody Category category) {
        System.out.println("Updating Customer " + id);


        Category currentCategory = categoryService.findById(id);

        if (currentCategory == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        currentCategory.setId(id);
        currentCategory.setName(category.getName());
        currentCategory.setEmployeeList(category.getEmployeeList());


        categoryService.save(currentCategory);
        return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
    }






}
