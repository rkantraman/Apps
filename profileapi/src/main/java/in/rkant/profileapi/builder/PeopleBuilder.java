package in.rkant.profileapi.builder;

import in.rkant.profileapi.entity.People;

public class PeopleBuilder {
	
	private People people;

	public PeopleBuilder() {
		this.people = new People();
	}
	
	public PeopleBuilder name(String name) {
		this.people.setName(name);
		return this;
	}
	
	public PeopleBuilder age(Integer age) {
		this.people.setAge(age);
		return this;
	}
	
	public PeopleBuilder company(String company) {
		this.people.setCompany(company);
		return this;
	}
	
	
	public People build() {
		return this.people;
	}
	
	
	
	
	

}
