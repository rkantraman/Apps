package in.rkant.profileapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.rkant.profileapi.entity.Product;
import in.rkant.profileapi.repo.ProductRepository;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
	
	
	@Autowired
	private ProductRepository productRepository; 
	
	@PostMapping(value = "/add")
	public void addProduct(@RequestParam String name, @RequestParam String price) {

		Product product = new Product(name, Double.valueOf(price));
		productRepository.save(product);
	}
	
 
	private List<Product> getProduct() {

		List<Product> findAll = (List<Product>) productRepository.findAll();
//		Page<Product> allProducts = productRepository.findAll(firstPageWithTwoElements);
		//
//			List<Product> allTenDollarProducts = 
//			  productRepository.findAllByPrice(10, secondPageWithFiveElements);
		return findAll;
	}
	

}
