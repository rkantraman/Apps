package in.rkant.profileapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import in.rkant.profileapi.entity.People;
import in.rkant.profileapi.repo.PeopleDao;

@RestController
@RequestMapping("v1/people")
public class PeopleApi {

	
	@Autowired
	private PeopleDao peopleDao;
	
	@PostMapping("/add")
	private ResponseEntity<People> savePerson(
			@RequestParam String name, 
			@RequestParam String age, 
			@RequestParam String nickName , 
			@RequestParam String company,
			@RequestParam String birthday,
			@RequestParam String married) {
		
		System.out.println("Saving ....");
//		new People(age, name, nickName, company, birthday, married);
		People people = new People(Integer.valueOf(age), name, nickName, company, new Date(), false);
		People save = peopleDao.save(people);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<People>> getAllPeople() {
		List<People> findAll = peopleDao.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(findAll);
	}
	
	
	public void deletePeople() {
//		peopleDao
 
	}
	
	
	public void searchPeople() {
		// TODO Auto-generated method stub

	}
	
	
	
}
