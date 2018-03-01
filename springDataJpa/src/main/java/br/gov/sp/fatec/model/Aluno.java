package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

@Entity
@Table(name = "alunos")
public class Aluno {

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    
	@JsonView(View.All.class)
    @Column(name = "nome", length = 30, nullable = false)
    private String nome;
    
	@JsonView(View.All.class)
    @Column(name = "ra", unique=true, length = 20, nullable = false)
    private String ra;
    
    @ManyToOne()
    @JoinColumn(name = "curso_id")
    private Curso curso;

    
    // Getters and setters
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
