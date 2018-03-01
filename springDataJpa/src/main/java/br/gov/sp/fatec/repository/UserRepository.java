package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findById(Long id);
}
