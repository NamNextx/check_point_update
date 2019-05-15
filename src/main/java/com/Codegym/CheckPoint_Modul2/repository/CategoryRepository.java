package com.Codegym.CheckPoint_Modul2.repository;

import com.Codegym.CheckPoint_Modul2.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
