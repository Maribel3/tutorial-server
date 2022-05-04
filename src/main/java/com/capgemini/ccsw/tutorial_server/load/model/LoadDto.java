package com.capgemini.ccsw.tutorial_server.load.model;

import java.security.Timestamp;
import java.sql.Date;

import com.capgemini.ccsw.tutorial_server.client.model.Client;
import com.capgemini.ccsw.tutorial_server.client.model.ClientDto;
import com.capgemini.ccsw.tutorial_server.game.model.GameDto;

public class LoadDto {

	private Long id;
	private GameDto game;
	private ClientDto client;
	private Date dateLoan;
	private Date dateReturn;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public GameDto getGame() {
		return game;
	}
	public void setGame(GameDto game) {
		this.game = game;
	}
	public ClientDto getClient() {
		return  client;
	}
	public void setClient(ClientDto client) {
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
