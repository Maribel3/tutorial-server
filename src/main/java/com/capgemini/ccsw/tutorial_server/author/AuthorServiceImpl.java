package com.capgemini.ccsw.tutorial_server.author;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial_server.author.model.Author;
import com.capgemini.ccsw.tutorial_server.author.model.AuthorDto;
import com.capgemini.ccsw.tutorial_server.author.model.AuthorSearchDto;


@Service
public class AuthorServiceImpl implements AuthorService{
	 
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public List<Author> findAll() {

	    return (List<Author>) this.authorRepository.findAll();
	}
	
	@Override
	public Author get(Long id) {

		return this.authorRepository.findById(id).orElse(null);
	}

	public Page<Author> getAuthor(int pageNumber, int pageSize){
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return this.authorRepository.findAll(page);

	}

    @Override
    public void save(Long id, AuthorDto data) {

        Author author = null;
        if (id != null)
            author = this.get(id);
        else
            author = new Author();

        BeanUtils.copyProperties(data, author, "id");

        this.authorRepository.save(author);
    }

   
    @Override
    public void delete(Long id) {

        this.authorRepository.deleteById(id);
    }

	@Override
	public Page<Author> findPage(AuthorSearchDto dto) {
		return this.authorRepository.findAll(dto.getPageable());
	}
}