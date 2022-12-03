package com.ucad.sn.repository;

import com.ucad.sn.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
}