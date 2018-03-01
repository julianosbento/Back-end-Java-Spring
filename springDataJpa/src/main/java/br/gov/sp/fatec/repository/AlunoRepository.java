package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
	
	public Aluno findByNome(String nome);
	
//	@Query("select u from aluno u where u.nome like %?1%")
	@Query("select a from Aluno as a join a.curso as c where c.nome like %?1%")
	public List<Aluno> buscaUsuarioPorCurso(String nomeCurso);

}
