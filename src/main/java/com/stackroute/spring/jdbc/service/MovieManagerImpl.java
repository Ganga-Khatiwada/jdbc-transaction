package com.stackroute.spring.jdbc.service;

import com.stackroute.spring.jdbc.model.Movie;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.spring.jdbc.dao.MovieDAO;

public class MovieManagerImpl implements MovieManager {

	private MovieDAO movieDAO;

	public void setMovieDAO(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	@Transactional
	public void createMovie(Movie cust)
	{
		movieDAO.create(cust);
	}

}
