package in.rkant.profileapi.service;

import java.util.List;

import in.rkant.profileapi.entity.People;

public interface PeopleService{
	
	
	public List<People> search(String name, String nikName, String company);
	

}
