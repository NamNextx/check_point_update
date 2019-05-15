package com.Codegym.CheckPoint_Modul2.service.impl;


import com.Codegym.CheckPoint_Modul2.model.Employee;
import com.Codegym.CheckPoint_Modul2.repository.EmployeeRepository;
import com.Codegym.CheckPoint_Modul2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService<Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void save(Employee dao) {
        employeeRepository.save(dao);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllByGenContainingOrNameContaining(String gen, String name,  Pageable pageable) {
        return employeeRepository.findAllByGenContainingOrNameContaining(gen,name,pageable);
    }
}
