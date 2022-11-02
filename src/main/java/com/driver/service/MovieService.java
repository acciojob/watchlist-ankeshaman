package com.driver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Director;
import com.driver.model.Movie;
import com.driver.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	MovieRepository movrepo;
	
	public String adMovie(Movie movie) {
		return movrepo.addMovie(movie);
	}
	
	public String adDirector(Director director) {
		return movrepo.addDirector(director);
	}
	
	public String adMovDirector(String mov, String director) {
		return movrepo.addMovieDirector(mov,director);
	}
	
	public Movie getMov(String mov) {
		return movrepo.getMovie(mov);
	}
	
	/*public List<String> getDirec(String direc) {
		return movrepo.getMovieByDirector(direc);
	}*/
	
	public List<String> getmovbyDir(String dir){
		return movrepo.getMovieByDirector(dir);
	}
	
	public List<String> getallMovie(){
		return movrepo.getAllMovie();
	}
	
	public String delete(String name) {
		return movrepo.deleteName(name);
	}
	
	public String deleteDirec() {
		return movrepo.deleteAll();
	}
	
	public Director getDirecName(String name) {
		return movrepo.getDirector(name);
	}
}
