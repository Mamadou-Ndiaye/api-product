package com.ucad.sn.service.impl;

import com.ucad.sn.domain.Category;
import com.ucad.sn.domain.Product;
import com.ucad.sn.repository.ProductRepository;
import com.ucad.sn.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private  final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product save(Product product) {
        log.info("ProductServiceImpl:createNewProduct execution started ");
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product update(Long id, Product product) {
        log.info("ProductServiceImpl:updateProduct execution started ");
        if( id == null)
        {
            log.error("Product not found");
            return  null;
        }
        log.info("ProductServiceImpl:updateProduct execution ended ");
        return  productRepository.save(product);
    }


    @Cacheable(value = "product")
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
          productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        if ( name == null)
        {
            log.error("Category is NULL");
            return  null;
        }
        return  productRepository.findByName(name);
    }

    @Override
    public List<Product> findByNameContainsIgnoreCase(String name) {
        return productRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public List<Product> findByNameAndPrix(String name, Double prix) {
        return productRepository.findByNameAndPrix(name,prix);
    }

    @Override
    public List<Product> findByNamePrix(String name, Double prix) {
        return productRepository.findByNamePrix(name,prix);
    }

    @Override
    public List<Product> findByNamePrixWithParam(String name, Double prix) {
        return productRepository.findByNamePrixWithParam(name, prix);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> findByCategory_Id(Long id) {
        if ( id == null)
        {
            log.error("Category is NULL");
            return  null;
        }
        return productRepository.findByCategory_Id(id);
    }

    @Override
    public List<Product> findByOrderByNameAsc() {
        return productRepository.findByOrderByNameAsc();
    }
}
