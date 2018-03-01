package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonView(View.All.class)
    private Long id;

    @JsonView(View.All.class)
    @Column(name="email", nullable=false)
    private String email;

    @JsonView(View.All.class)
    @Column(name="password", nullable=false)
    private String password;
}
