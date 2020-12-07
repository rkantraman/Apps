package in.rkant.profileapi.repo;

import org.springframework.data.repository.CrudRepository;

import in.rkant.profileapi.entity.Kayak;

public interface KayakDao extends CrudRepository<Kayak, Integer> {
}