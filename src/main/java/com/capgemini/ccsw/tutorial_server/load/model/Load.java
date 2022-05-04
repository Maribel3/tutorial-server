package com.capgemini.ccsw.tutorial_server.load.model;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Temporal;

import com.capgemini.ccsw.tutorial_server.client.model.Client;
import com.capgemini.ccsw.tutorial_server.client.model.ClientDto;
import com.capgemini.ccsw.tutorial_server.game.model.Game;
import com.capgemini.ccsw.tutorial_server.game.model.GameDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Load")
public class Load {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "game_id", nullable = false)
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	
	@Column(name = "date_loan", nullable = false)
    
	
	private Date dateLoan;
	
	@Column(name = "date_return", nullable = false)
   

	
	private Date dateReturn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDateLoan() {
		return dateLoan;
	}

	public void setDateLoan(Date dateLoan) {
		this.dateLoan = dateLoan;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	

}
