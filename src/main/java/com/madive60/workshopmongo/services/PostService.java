package com.madive60.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madive60.workshopmongo.domain.Post;
import com.madive60.workshopmongo.repository.PostRepository;
import com.madive60.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
		
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}

}
