package br.gov.sp.fatec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.service.CursoService;

// mvn exec:java -Dexec.mainClass=br.gov.sp.fatec.App

public class App 
{

	public static void main( String[] args )
    {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		CursoService cursoService = (CursoService) context.getBean("cursoService");
		
		try {
			cursoService.iniciarCurso();
		} catch(Exception e) {
				System.out.println("Erro esperado! Rollback realizado!");
				e.printStackTrace();
		}
		
		Curso curso = cursoService.buscarCursoPorNome("ADS");
		Aluno primeiroAluno = cursoService.buscarPrimeiroAlunoPorNomeDoCurso("ADS");
		
		System.out.println("Curso: " + curso.getNome());		
		System.out.println("Aluno: " + primeiroAluno.getNome());
		
		cursoService.removerCursosEAlunos();
		
		
		
//		Curso cursoAds = new Curso();
//		cursoAds.setNome("ADS");
//		cursoRepo.save(cursoAds);

		
//		Aluno aluno1 = new
		
//		// Recupera os repositorios
//		AutorizacaoRepository autorizacaoRepo = (AutorizacaoRepository) 
//				context.getBean("autorizacaoRepository");
//		UsuarioRepository usuarioRepo = (UsuarioRepository) context.getBean("usuarioRepository");
//		
//		// Cria autorizacoes
//		Autorizacao autorizacao1 = new Autorizacao();
//		autorizacao1.setNome("Usu�rio");
//		
//		autorizacaoRepo.save(autorizacao1);
//		
//		Autorizacao autorizacao2 = new Autorizacao();
//		autorizacao2.setNome("Administrador");
//		
//		autorizacaoRepo.save(autorizacao2);
//		
//		// Cria um usuario
//		Usuario usuario = new Usuario();
//		usuario.setNome("Paulo");
//		usuario.setSenha("senha");
//		usuario.setAutorizacoes(new ArrayList<Autorizacao>());
//		usuario.getAutorizacoes().add(autorizacao1);
//		usuario.getAutorizacoes().add(autorizacao2);
//		
//		usuarioRepo.save(usuario);
//		
//		System.out.println("Id: " + usuario.getId());
//		
//		// Realiza varias consultas
//		System.out.println("Resultado da busca 1: " + usuarioRepo.findByNome("Paulo").getNome());
//		
//		System.out.println("Resultado da busca 2: " + usuarioRepo.findTop1ByNomeContains("au").getNome());
//
//		for(Usuario us: usuarioRepo.findByIdGreaterThan(0l)) {
//			System.out.println("Usuario encontrado: " + us.getNome());
//		}
//		
//		for(Usuario us: usuarioRepo.findByAutorizacoesNome("Usuario")) {
//			System.out.println("Usuario encontrado 2: " + us.getNome());
//		}
//		
//		for(Usuario us: usuarioRepo.buscaUsuario("au")) {
//			System.out.println("Usuario encontrado 3: " + us.getNome());
//		}
//		
//		SegurancaService seg = (SegurancaService)context.getBean("segurancaService");
//		
//		try {
//			seg.exemploTransacao();
//		}
//		catch(Exception e) {
//			System.out.println("Erro esperado! Rollback realizado!");
//			e.printStackTrace();
//		}
//		
//		// Exclui usuario
//		usuarioRepo.delete(usuario);
//		// Exclui autorizacoes
//		autorizacaoRepo.delete(autorizacao1);
//		autorizacaoRepo.delete(autorizacao2);

    }
    
}
