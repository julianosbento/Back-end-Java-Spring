package br.gov.sp.fatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.service.CursoService;
import br.gov.sp.fatec.view.View;



@RestController
@RequestMapping(value = "/cursos")
public class AlunoController {

	@Autowired
	private CursoService cursoService;
	
	public void setUsuarioService(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	
	@RequestMapping(value="/teste")
	@JsonView(View.All.class)
	public ResponseEntity<Aluno> get() {
		System.out.println("CHEGOU AUQI PORRA");
//		cursoService.iniciarCurso();
		Aluno aluno = cursoService.buscarPrimeiroAlunoPorNomeDoCurso("ADS");
		
		System.out.println(aluno.getNome());
		
//		Aluno aluno = new Aluno();
//		aluno.setNome("xerecudo");
		
		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}

//	@RequestMapping(value = "/get/{nome}")
//	@JsonView(View.All.class)
//	public ResponseEntity<Collection<Usuario>> pesquisar(@PathVariable("nome") String nome) {
//		return new ResponseEntity<Collection<Usuario>>(usuarioService.buscar(nome), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/getById")
//	@JsonView(View.class)
//	public ResponseEntity<Aluno> get(@RequestParam(value="id", defaultValue="1") Long id) {
//		Aluno aluno  = cursoService.buscarPrimeiroAlunoPorNomeDoCurso("ADS");
//		if(aluno == null) {
//			return new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
//	}
}