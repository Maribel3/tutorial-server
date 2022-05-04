package com.capgemini.ccsw.tutorial_server.author.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
//@JsonSubTypes({
 //   @JsonSubTypes.Type(Author.class),
  //  @JsonSubTypes.Type(AuthorDto.class) })
public class AuthorSearchDto{
	
	private int pageSize;
    private int pageNumber;
    private Pageable pageable;
    public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getPageNumber() {
		return pageNumber;
	}


	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


	
   
    public Pageable getPageable() {

        return this.pageable;
    }

    
    public void setPageable(Pageable pageable) {

        this.pageable = pageable;
    }


}


   
