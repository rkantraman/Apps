package in.rkant.profileapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import in.rkant.profileapi.entity.People;

public interface PeopleDao extends JpaRepository<People, Long>, JpaSpecificationExecutor<People> {
	
}

 