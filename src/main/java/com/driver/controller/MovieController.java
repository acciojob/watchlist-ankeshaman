package com.driver.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.driver.model.Director;
import com.driver.model.Movie;
import com.driver.service.MovieService;


@RestController
@RequestMapping("movies")
public class MovieController {
	@Autowired
	MovieService mov;
	
	@PostMapping("/add-movie")
	public ResponseEntity<String> addMovie(@RequestBody Movie movie){
		String message=mov.adMovie(movie);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@PostMapping("/add-director")
	public ResponseEntity<String> addDirector(@RequestBody Director director){
		String message=mov.adDirector(director);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@PostMapping("/add-movie-director-pair")
	public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName,
			             @RequestParam String directorName){
		String message=mov.adMovDirector(movieName,directorName);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@GetMapping("/get-movie-by-name/{name}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName){
		Movie message=mov.getMov(movieName);
		return new ResponseEntity<Movie>(message,HttpStatus.CREATED);
    }
	
	@GetMapping("/get-movies-by-director-name/{director}")
	public ResponseEntity<List<String>> getMoviesByDirectorName(@PathParam("director") String directorName){
		List<String> message=mov.getmovbyDir(directorName);
		return new ResponseEntity<List<String>>(message,HttpStatus.CREATED);
    }
	
	@GetMapping("/movies/get-director-by-name/{name}")
	public ResponseEntity<Director>getDirectorByName(@PathVariable String name){
		Director message=mov.getDirecName(name);
		return new ResponseEntity<Director>(message,HttpStatus.CREATED);
	}
	
	@GetMapping("/get-all-movies")
	public ResponseEntity<List<String>> findAllMovies(){
		List<String> message=mov.getallMovie();
		return new ResponseEntity<List<String>>(message, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete-director-by-name")
	public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){
		String message=mov.delete(name);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete-all-directors")
	public ResponseEntity<String> deleteAllDirectors(){
		String message=mov.deleteDirec();
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}

}

