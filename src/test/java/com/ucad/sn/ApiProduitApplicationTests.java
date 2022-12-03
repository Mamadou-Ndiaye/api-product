package com.ucad.sn;

import com.ucad.sn.domain.Category;
import com.ucad.sn.domain.Product;
import com.ucad.sn.repository.CategoryRepository;
import com.ucad.sn.service.CategoryService;
import com.ucad.sn.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
class ApiProduitApplicationTests {

	@Autowired
	private ProductService productService;

	@Autowired
   private CategoryService categoryService;
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateProduct() {
		/*Category category = new Category();
		category.setNom("Computer");
		categoryService.save(category);
		Product prod = new Product(5L,"PC Dell",2200.500, LocalDate.now(),category);
		Product productSaved = productService.save(prod);
		assertNotNull(productSaved);
		assertEquals(productSaved.getId(), prod.getId());
		assertEquals(productSaved.getName(), prod.getName());*/

	}

}
