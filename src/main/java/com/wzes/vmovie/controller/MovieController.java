package com.wzes.vmovie.controller;

import com.wzes.vmovie.dao.MovieMapper;
import com.wzes.vmovie.model.MovieCollection;
import com.wzes.vmovie.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Create by xuantang
 * @date on 10/31/17
 */
@RestController
@RequestMapping({"/vmovie"})
public class MovieController {

    @Autowired
    MovieMapper movieMapper;


    @PostMapping(value = "/movie_collection")
    private String addMovieCollection(@RequestParam String username,
                                      @RequestParam String movie_id){
        MovieCollection movieCollection = new MovieCollection(username, movie_id);
        int code = movieMapper.addMovieCollection(movieCollection);
        Result result = new Result(String.valueOf(code), "");
        return result.toString();
    }

    @GetMapping(value = "/movie_collections/{username}")
    private String getMovieCollection(@PathVariable String username){
        return null;
    }

}
