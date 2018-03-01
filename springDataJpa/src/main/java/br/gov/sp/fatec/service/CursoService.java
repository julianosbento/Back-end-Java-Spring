package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.repository.AlunoRepository;
import br.gov.sp.fatec.repository.CursoRepository;

public interface CursoService {
	public void iniciarCurso();
	public Curso buscarCursoPorNome(String nome);
	public Aluno buscarPrimeiroAlunoPorNomeDoCurso(String nomeCurso);
	public void removerCursosEAlunos();
}
