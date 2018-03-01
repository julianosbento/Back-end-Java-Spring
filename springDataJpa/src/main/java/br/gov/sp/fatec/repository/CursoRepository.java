package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.model.Usuario;

public interface CursoRepository extends CrudRepository<Curso, Long> {
	public Curso findByNome(String nome);
}
