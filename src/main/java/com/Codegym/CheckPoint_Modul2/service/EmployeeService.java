package com.Codegym.CheckPoint_Modul2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService<T> {
    Iterable<T> findAll();
    T findById(Long id);
    void save(T dao);
    void remove(Long id);
    Page<T> findAll(Pageable pageable);
    Page<T> findAllByGenContainingOrNameContaining(String gen,String name,Pageable pageable);
}
