package com.ucad.sn.repository;

import com.ucad.sn.domain.Category;
import com.ucad.sn.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    List<Product> findByNameContainsIgnoreCase(String name);

    List<Product> findByNameAndPrix(String name, Double prix);

    /**
     * Query with JPQL
     * @param name the name of product
     * @param prix the price of product
     * @return List product
     */

    @Query("Select p from Product  p where  p.name like %?1 and p.prix > ?2 ")
    List<Product> findByNamePrix(String name, Double prix);



    /**
     * Query with JPQL avec des parametres nommees
     * @param name the name of product
     * @param prix the price of product
     * @return List product
     */

    @Query("Select p from Product  p where  p.name like %:name and p.prix >:prix")
    List<Product> findByNamePrixWithParam(@Param("name") String name, @Param("prix") Double prix);


    List<Product> findByCategory(Category category);

    List<Product> findByCategory_Id(Long id);

    List<Product> findByOrderByNameAsc();
}