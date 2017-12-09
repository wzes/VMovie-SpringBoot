package com.wzes.vmovie.controller;

import com.wzes.vmovie.dao.MovieMapper;
import com.wzes.vmovie.model.MovieCollection;
import com.wzes.vmovie.model.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Create by xuantang
 * @date on 10/31/17
 */
@RestController
@RequestMapping({"/vmovie"})
public class MovieController {
    private static Logger log = LogManager.getLogger(MovieController.class); //日志输出
    @Autowired
    MovieMapper movieMapper;


    @RequestMapping(value = "/movie_collection", method = RequestMethod.POST)
    private String addMovieCollection(@RequestParam String username,
                                      @RequestParam String movie_id,
                                      @RequestParam String data) {
        MovieCollection movieCollection = new MovieCollection(username, movie_id, data);
        movieMapper.addMovieCollection(movieCollection);
        log.info(movieCollection.toString());
        return movieCollection.toString();

    }

    @GetMapping(value = "/{username}/movie_collections", produces = {"application/xml;charset=UTF-8"})
    private String getMovieCollection(@PathVariable String username) {
        List<MovieCollection> movieCollections = movieMapper.findMovieCollection(username);
        // build xml file
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<movies xmlns=\"http://www.microsoft.com\"\n" +
                "\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "\txsi:SchemaLocation=\"http://59.110.136.134/documents/movie.xsd\">");
        for (MovieCollection movieCollection : movieCollections) {
            sb.append("<movie>");
            sb.append("<id>").append(movieCollection.getMovie_id()).append("</id>");
            sb.append("<data>").append(movieCollection.getData()).append("</data>");
            sb.append("</movie>");
        }
        sb.append("</movies>");
        log.info(movieCollections.size());
        return sb.toString();
    }

    @RequestMapping(value = "/{username}/movie_collection/{movie_id}", method = RequestMethod.DELETE)
    private int removeMovieCollection(@PathVariable String username, @PathVariable String movie_id) {
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.setUsername(username);
        movieCollection.setMovie_id(movie_id);
        return movieMapper.removeMovieCollection(movieCollection);
    }
}