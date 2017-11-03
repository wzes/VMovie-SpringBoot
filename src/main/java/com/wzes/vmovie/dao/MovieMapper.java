package com.wzes.vmovie.dao;

import com.wzes.vmovie.model.MovieCollection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Create by xuantang
 * @date on 10/31/17
 */

@Mapper
public interface MovieMapper {

    @Select("SELECT data, movie_id FROM movie_collection WHERE username = #{username}")
    List<MovieCollection> findMovieCollection(String username);

    @Insert("INSERT INTO movie_collection (username, movie_id, data) VALUES (#{username}, #{movie_id}, #{data});")
    int addMovieCollection(MovieCollection movieCollection);

    @Delete("DELETE FROM movie_collection WHERE username = #{username} and movie_id = #{movie_id}")
    int removeMovieCollection(MovieCollection movieCollection);
}
