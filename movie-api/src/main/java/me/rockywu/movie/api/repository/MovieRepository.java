package me.rockywu.movie.api.repository;

import me.rockywu.movie.api.pojo.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * Spring Data JPA默认会提供很多具有对数据库各种操作的接口, 比如CrudRepository, PageingandSortingRepository等, 我们只需要继承该接口,
 * Spring就会自动帮我们在运行的时候进行加载变成可以使用的Bean, 并且会自动实现对应接口的方法, 这样我们就可以在Controller和Service层来直接使用了
 * 如果默认的interface提供的方法不能满足我们的需求, 也可以直接在扩展后得接口上编写自己的接口方法, 我们只管编写方法名称, Spring会自动按照方法的
 * 命名规则来实现具体的方法.
 *
 *
 * @author RockyWu
 * @date 2018/10/14
 */
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    List<Movie> findByDirector(String director);
}
