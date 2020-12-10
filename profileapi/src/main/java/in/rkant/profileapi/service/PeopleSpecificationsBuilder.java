package in.rkant.profileapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import in.rkant.profileapi.entity.People;

public class PeopleSpecificationsBuilder {
	private final List<SearchCriteria> params;

	public PeopleSpecificationsBuilder() {
		super();
		this.params = new ArrayList<SearchCriteria>();

	}

	public PeopleSpecificationsBuilder with(SearchCriteria searchCriteria) {
		this.params.add(searchCriteria);
		return this;
	}

	public Specification<People> build() {

		List<Specification<People>> specs = new ArrayList<Specification<People>>();

		for (SearchCriteria searchCriteria : params) {
			PeopleSpecification actividadSpecification = new PeopleSpecification(searchCriteria);
			specs.add(actividadSpecification);
		}

		Specification<People> result = specs.get(0);

		for (int i = 1; i < params.size(); i++) {
			
			SearchCriteria searchCriteria = params.get(i -1);
			Specification<People> current = specs.get(i);
			
			if(searchCriteria.getPerdicateType().equals("or")) {
				result = Specification.where(result).or(current);
			}else {
				result = Specification.where(result).and(current);
			}

		}

		return result;

	}

}
