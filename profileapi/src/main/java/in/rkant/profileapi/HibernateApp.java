package in.rkant.profileapi;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import in.rkant.profileapi.entity.People;
import in.rkant.profileapi.repo.PeopleDao;
import in.rkant.profileapi.service.PeopleSpecificationsBuilder;
import in.rkant.profileapi.service.SearchCriteria;

@SpringBootApplication
public class HibernateApp  implements CommandLineRunner {
	
	@Autowired
	private EntityManager em;
	@Autowired
	private PeopleDao peopleDao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateApp.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome !");
		System.out.println(em);
		 
//		addPeople(new People(4, "Raguhveer", "Oracle", null, new Date(), false));
		
		try {
			
			
			PeopleSpecificationsBuilder peopleSpecificationsBuilder = new PeopleSpecificationsBuilder();
			Sort orden = Sort.by("id").ascending();
			Pageable pagReq = PageRequest.of(0, 50, orden);
			
			peopleSpecificationsBuilder.with(new SearchCriteria("name", "IS LIKE", "Ram", "or"));
			peopleSpecificationsBuilder.with(new SearchCriteria("name", "IS LIKE", "war", "AND"));
//			peopleSpecificationsBuilder.with(new SearchCriteria("nickName", "IS LIKE", "Meh", "or"));
//			peopleSpecificationsBuilder.with(new SearchCriteria("company", "IS LIKE", "Deloit", "or"));
			
			Specification<People> build = peopleSpecificationsBuilder.build();
			
			
			Page<People> findAll = peopleDao.findAll(build, pagReq);
			
			System.out.println("\n\n");
			
			for(People people : findAll) {
				System.out.println(people);
			}
			
			System.out.println("\n\n");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.exit(0);

		}
		
		
	}
	
	@Transactional
	public void addPeople(People people) {
		People save = peopleDao.save(people);
		System.out.println(save);
	}
	
	
	

}
