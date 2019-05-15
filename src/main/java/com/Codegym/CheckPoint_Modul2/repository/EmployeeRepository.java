package com.Codegym.CheckPoint_Modul2.repository;

import com.Codegym.CheckPoint_Modul2.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    Page<Employee> findAllByGenContainingOrNameContaining(String gen, String name, Pageable pageable);
}
