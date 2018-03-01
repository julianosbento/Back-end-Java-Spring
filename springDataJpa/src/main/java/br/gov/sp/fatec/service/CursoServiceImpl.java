package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.repository.AlunoRepository;
import br.gov.sp.fatec.repository.CursoRepository;

@Service("cursoService")
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private CursoRepository cursoRepo;
	@Autowired
	private AlunoRepository alunoRepo;

	@Override
	@Transactional
	public void iniciarCurso() {
		
		Curso cursoAds = new Curso();
		cursoAds.setNome("ADS");
		
		cursoRepo.save(cursoAds);
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Matheus");
		aluno1.setRa("14020202020202");
		aluno1.setCurso(cursoAds);
		
		alunoRepo.save(aluno1);
	}
	
	@Override
	public Curso buscarCursoPorNome(String nome) {
		Curso cursoAds = cursoRepo.findByNome(nome);
		return cursoAds;
	}
	
	@Override
	public Aluno buscarPrimeiroAlunoPorNomeDoCurso(String nomeCurso) {
		Aluno aluno = alunoRepo.buscaUsuarioPorCurso(nomeCurso).get(0);
		return aluno;
	}
	
	@Override
	public void removerCursosEAlunos() {
		alunoRepo.deleteAll();
		cursoRepo.deleteAll();
	}

	
	public void setCursoRepo(CursoRepository cursoRepo) {
		this.cursoRepo = cursoRepo;
	}
	public void setAlunoRepo(AlunoRepository alunoRepo) {
		this.alunoRepo = alunoRepo;
	}

}
