package com.Codegym.CheckPoint_Modul2.service;

public interface CategoryService <T> {
    T findById(Long id);
    void save(T category);
    void remove(Long id);
    Iterable<T> findAll();
}
