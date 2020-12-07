package in.rkant.profileapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.rkant.profileapi.entity.People;
import in.rkant.profileapi.repo.PeopleDao;

@RestController
public class Api {
	
	@Autowired
	private PeopleDao peopleDao;
	
	@GetMapping("/")
	public String[] ping() {
		
		
//		People people1 = new People("Ravi", "patna");
//		People people2 = new People("Ravi", "patna");
//		People people3 = new People("Ravi", "patna");
//		People people4 = new People("Ravi", "patna");
//		People people5 = new People("Ravi", "patna");
//		People people1 = new People("Ravi", "patna");
//		People people1 = new People("Ravi", "patna");
//		
//		Optional<People> findById = peopleDao.findById(new Integer(3));
//		peopleDao.save(people1);
		
		
		String[] result = {"Ravi", "Sharma"};
		return result;
	}

	
}
