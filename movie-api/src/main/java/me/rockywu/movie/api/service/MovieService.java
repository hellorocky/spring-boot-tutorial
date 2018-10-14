package me.rockywu.movie.api.service;

import com.google.common.collect.Lists;

import me.rockywu.movie.api.pojo.Movie;
import me.rockywu.movie.api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

/**
 *
 * repository层提供了很多操作数据库的方法, 一般按照Java的开发规范, 主要的业务逻辑会放到service层, 比如默认的repository的findAll会返回所有的
 * 数据, 没有任何条件和逻辑, 这时候可以在service层加一些逻辑, 过滤掉空数据.Lists.newArrayList会把Iterator转成
 * @author RockyWu
 * @date 2018/10/14
 */
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        Iterable<Movie> movies = movieRepository.findAll();
        if (movies == null) {
            return Collections.emptyList();
        }
        return Lists.newArrayList((movies));
    }

}
