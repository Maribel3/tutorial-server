package com.capgemini.ccsw.tutorial_server.load.model;

import org.springframework.data.domain.Pageable;

import java.util.Date;

public class LoadSearchDto {

	Long gameId;

	Long clientId;

	String date;

	private Pageable pageable;

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Pageable getPageable() {

		return this.pageable;
	}

	public void setPageable(Pageable pageable) {

		this.pageable = pageable;
	}
}
