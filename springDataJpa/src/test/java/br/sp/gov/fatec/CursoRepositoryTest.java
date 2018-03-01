package br.sp.gov.fatec;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.repository.AlunoRepository;
import br.gov.sp.fatec.repository.CursoRepository;
import br.gov.sp.fatec.service.CursoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/CursoRepositoryTest-context.xml" })
@Rollback
@Transactional
public class CursoRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	AlunoRepository alunoRepo;
	@Autowired
	CursoRepository cursoRepo;
	@Autowired
	CursoService cursoService;
	
	@Before
	public void setUp() {
		cursoService.iniciarCurso();
	}
	
	public void setAlunoRepo(AlunoRepository alunoRepo) {
		this.alunoRepo = alunoRepo;
	}
	public void setCursoRepo(CursoRepository cursoRepo) {
		this.cursoRepo = cursoRepo;
	}
	
	@Test
	public void testeCursoServiceBuscarCursoPorNome() {
		Curso curso = this.cursoService.buscarCursoPorNome("ADS");
		assertTrue(curso.getId() != null);
	}
	
	@Test
	public void testeCursoServiceBuscarPrimeiroAlunoPorNomeDoCurso() {
		Aluno aluno = this.cursoService.buscarPrimeiroAlunoPorNomeDoCurso("ADS");
		assertTrue(aluno.getId() != null);
		assertTrue(aluno.getCurso().getNome() == "ADS");	
	}
	
	@Test
	public void testeCursoServiceRemoverCursosEAlunos() {
		this.cursoService.removerCursosEAlunos();
		Curso curso = this.cursoService.buscarCursoPorNome("ADS");
		assertTrue(curso == null);
	}
	
	@Test
	public void testeCursoRepositorySave() {
		Curso curso = new Curso();
		curso.setNome("BANCO");
		cursoRepo.save(curso);
		assertTrue(curso.getId() != null);
		assertTrue(curso.getNome() == "BANCO");
	}
	
	@Test
	public void testeCursoRepositoryUpdate() {
		Curso curso = new Curso();
		curso.setNome("BANCO");
		cursoRepo.save(curso);
		
		curso.setNome("TESTE");
		// updating
		cursoRepo.save(curso);
		
		Curso teste = cursoRepo.findByNome("TESTE");
		assertTrue(teste.getNome() == "TESTE");
	}
	
	@Test
	public void testeCursoRepositoryDelete() {
		Curso curso = new Curso();
		curso.setNome("BANCO");
		cursoRepo.save(curso);
		
		cursoRepo.delete(curso);
		
		Curso curso2 = cursoRepo.findByNome("BANCO");
		assertTrue(curso2 == null);
	}
}
