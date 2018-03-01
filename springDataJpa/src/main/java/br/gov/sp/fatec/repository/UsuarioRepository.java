package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	public Usuario findById(Long id);

	public Usuario findByNome(String nome);
	
	public Usuario findTop1ByNomeContains(String nome);
	
	public List<Usuario> findByIdGreaterThan(Long id);
	
	public List<Usuario> findByAutorizacoesNome(String nome);
	
	@Query("select u from Usuario u where u.nome like %?1%")
	public List<Usuario> buscaUsuario(String nome);
}
