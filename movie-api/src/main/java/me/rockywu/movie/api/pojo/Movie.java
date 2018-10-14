package me.rockywu.movie.api.pojo;

import javax.persistence.*;

/**
 * pojo是plain old java object的简称, 其实就是一个拥有私有变量和getter/setter方法的类.或者成为entity, javabean等, 基本上是一样的.
 * JPA是Java Persistence API的简称, 是一套Sun公司基于hebernate等ORM框架的基础上制定一套ORM规范, 想要统一ORM的标准, JPA是规范, hibernate是实现
 * Entity注解表明该POJO是一个实体, 用来映射一个表, 默认情况下对应的数据库的表名对应该POJO的名称, 比如Movie会对应movie表, MovieInfo会对应movie_info
 * 表, 如果有特殊情况, 可以配合Table(name="table name")来显性指定表的名称
 * Id注解表名该属性是主键, GeneratedValue注解指明了该值是自动生成的, 并指定了自动生成的规则.
 *
 * @author RockyWu
 * @date 2018/10/14
 */

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private String director;
    private String actor;
    private float rate;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", actor='" + actor + '\'' +
                ", rate=" + rate +
                '}';
    }
}
