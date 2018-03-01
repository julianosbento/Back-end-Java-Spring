package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

@Entity
@Table(name="appointment")
public class Appointment {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonView(View.All.class)
    private Long id;

    @JsonView(View.All.class)
    @Column(name="date", nullable=false)
    private String date;

    @JsonView(View.All.class)
    @ManyToOne()
    @JoinColumn(name="user_id")
    private Usuario usuario;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
