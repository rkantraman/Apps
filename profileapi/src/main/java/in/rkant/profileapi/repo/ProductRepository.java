package in.rkant.profileapi.repo;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.rkant.profileapi.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	
	List<Product> findAllByPrice(double price, Pageable pageable);
	
	Pageable firstPageWithTwoElements = PageRequest.of(0, 2);

	Pageable secondPageWithFiveElements = PageRequest.of(1, 5);
	
	
//	Page<Product> allProducts = productRepository.findAll(firstPageWithTwoElements);
//
//	List<Product> allTenDollarProducts = 
//	  productRepository.findAllByPrice(10, secondPageWithFiveElements);
	

}
