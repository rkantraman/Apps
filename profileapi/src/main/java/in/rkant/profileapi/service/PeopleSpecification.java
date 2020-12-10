package in.rkant.profileapi.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.data.jpa.domain.Specification;

import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

import in.rkant.profileapi.entity.People;

public class PeopleSpecification implements Specification<People> {

	private static final long serialVersionUID = 1L;
	private SearchCriteria searchcriteria;

	public PeopleSpecification() {}

	public PeopleSpecification(SearchCriteria searchcriteria) {
		super();
		this.searchcriteria = searchcriteria;
	}

	@Override
	public Predicate toPredicate(Root<People> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		
 
 
		Predicate like = criteriaBuilder.like(root.<String>get(searchcriteria.getKey()), "%"+searchcriteria.getValue()+"%");
		
		
		
		return like;
		
	}

 
}
