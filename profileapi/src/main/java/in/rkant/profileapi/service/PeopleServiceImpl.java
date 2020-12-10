package in.rkant.profileapi.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rkant.profileapi.entity.People;

@Service
public class PeopleServiceImpl implements PeopleService  {
	
	@Autowired
	private EntityManager entityManager;
	
	
	
	
	
	public List<People> search(String name, String nikName, String company){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<People> queryPeople = criteriaBuilder.createQuery(People.class);
		Root<People> rootPeople = queryPeople.from(People.class);
		Predicate like = criteriaBuilder.like(rootPeople.get("name"), "%"+name+"%");
		queryPeople.where(like);
		TypedQuery<People> createQuery = entityManager.createQuery(queryPeople);
		List<People> resultList = createQuery.getResultList();
		return resultList;
	}
	

}
