package com.driver.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.driver.model.Director;
import com.driver.model.Movie;

@Component
public class MovieRepository {
	List<Movie> l=new ArrayList<>();
	List<Director> d=new ArrayList<>();
	HashMap<String,List<String>> hm=new HashMap<>();
	
	public String addMovie(Movie movie) {
		l.add(movie);
		return "movie successfully added";
	}
	
	public String addDirector(Director direct) {
		d.add(direct);
		return "director successfully added";
	}
	
	public String addMovieDirector(String movie,String direct) {
		if(hm.containsKey(direct)) {
			List<String> al=hm.get(direct);
			al.add(movie);
			hm.put(direct, al);
		}
		else {
			hm.putIfAbsent(direct, new ArrayList());
			List<String> al=hm.get(direct);
			al.add(movie);
			hm.put(direct,al);
		}
		return "successfully added";
	}
	
	public Movie getMovie(String movie) {
		for(Movie m:l) {
			if(m.getName().equals(movie)) {
			    return m;
			}
		}
		return null;
	}
	
	public Director getDirector(String direc) {
		for(Director dir:d) {
			if(dir.getName().equals(direc)) {
			    return dir;
			}
		}
		return null;
	}
	public List<String> getMovieByDirector(String direc) {
		if(hm.containsKey(direc)) {
		    return hm.get(direc);
		}
		else {
		    return null;
		}
	}
	
	public List<String> getAllMovie() {
		List<String> movie=new ArrayList<>();
		for(Movie mov:l) {
			movie.add(mov.getName());
		}
		return movie;
	}
	
	public String deleteName(String name) {
		if(hm.containsKey(name)) {
		    hm.remove(name);
		}
		return "successfully deleted";
	}
	
	public String deleteAll() {
		while(d.size()>0) {
			d.remove(0);
		}
		return "successfully deleted";
	}
	
}

