package com.ucad.sn.service;

import com.ucad.sn.domain.Category;
import com.ucad.sn.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {


    Product save(Product product);

    Product findById(Long id);

    Product update(Long id ,Product product);

    List<Product>  findAll();

    void  deleteById(Long id);

    /**
     *  Get product by name
     * @param name
     * @return list Product
     */
    List<Product> findByName(String name);

    /**
     *  Get product by name containing and ignore case
     * @param name
     * @return list Product
     */
    List<Product> findByNameContainsIgnoreCase(String name);

    /**
     *  Get all product with respect the predicate
     * @param name of product
     * @param prix of product
     * @return list product
     */
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


    /**
     *  Get all product by category
     * @param category
     * @return list product
     */
    List<Product> findByCategory(Category category);

    /**
     *  Get all product by category_id
     * @param id
     * @return list product
     */
    List<Product> findByCategory_Id(Long id);

    /**
     * Get all product order by name asc
     * @return llist product
     */
    List<Product> findByOrderByNameAsc();
}
