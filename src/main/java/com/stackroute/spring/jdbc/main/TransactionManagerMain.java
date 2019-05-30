package com.stackroute.spring.jdbc.main;

import com.stackroute.spring.jdbc.model.Actor;
import com.stackroute.spring.jdbc.service.MovieManagerImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stackroute.spring.jdbc.model.Movie;
import com.stackroute.spring.jdbc.service.MovieManager;

public class TransactionManagerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		MovieManager movieManager = ctx.getBean("movieManager",MovieManagerImpl.class);
		Movie cust = createDummyCustomer();
		movieManager.createMovie(cust);
		ctx.close();
	}

	private static Movie createDummyCustomer() {
		Movie movie = new Movie();
		movie.setMovieId(4);
		movie.setMovieName("Raaz");
		movie.setReleaseYear(2008);
		movie.setRatings(5);
		Actor actor = new Actor();
		actor.setActorId(3);
		actor.setActorName("Bipasha Basu");
		// setting value more than 20 chars, so that SQLException occurs
		actor.setGender("Female");
		actor.setAge(32);
		movie.setActor(actor);
		return movie;
	}

}
