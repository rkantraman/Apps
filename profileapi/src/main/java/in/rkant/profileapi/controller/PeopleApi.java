package in.rkant.profileapi.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.hibernate.boot.model.source.spi.TableSpecificationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.rkant.profileapi.builder.PeopleBuilder;
import in.rkant.profileapi.entity.People;
import in.rkant.profileapi.repo.PeopleDao;
import in.rkant.profileapi.service.PeopleService;

@RestController
@RequestMapping("v1/people")
public class PeopleApi {

	
	@Autowired
	private PeopleDao peopleDao;
	@Autowired
	private PeopleService  peopleService;
	
	@PostMapping("/add")
	private ResponseEntity<People> savePerson(
			@RequestParam String name, 
			@RequestParam String age, 
			@RequestParam String nickName, 
			@RequestParam String company,
			@RequestParam String birthday,
			@RequestParam String married) {
		
		System.out.println("Saving ....");
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
	
	
	@GetMapping("/getFiltered")
	public ResponseEntity<List<People>> searchPeople( @RequestParam String name) {
	 
		List<People> search = peopleService.search(name, "", "");
		System.out.println(search.size());
		return ResponseEntity.status(HttpStatus.OK).body(search);

	}
	
	
	@GetMapping("/csv")
	public ResponseEntity<Resource> getFile(
			@RequestParam String name,
			@RequestParam String age,
			@RequestParam String nickName,
			@RequestParam String company,
			@RequestParam String birthday,
			@RequestParam String married
			) {
		
	 
		
		String filename = name+"_row_data.csv";
		InputStreamResource file = null;
		
		
		
		List<People> peopleData = peopleDao.findAll();
		
		
		final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
		
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
		        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
			
			for(People people : peopleData) {
				
				List<String> asList = Arrays.asList(
						String.valueOf(people.getId()),
						people.getName(),
						people.getNickName(),
						people.getCompany(),
						String.valueOf(people.getAge()),
						people.getBirthday().toString()
				);
				csvPrinter.printRecord(asList);
			}
			csvPrinter.flush();
			ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
			file = new InputStreamResource(in);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	    
		return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/csv"))
		        .body(file);
		
	}
	
	
	
}
