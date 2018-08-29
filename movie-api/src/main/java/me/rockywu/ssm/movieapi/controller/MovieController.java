package me.rockywu.ssm.movieapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @GetMapping
    public List<DoubanMovie> getAll() {
        List<DoubanMovie> list = new ArrayList<DoubanMovie>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.AUGUST, 30, 0, 0);
        list.add(new DoubanMovie(1, "Rocky", "Stalon", calendar.getTime()));
        return list;
    }
}
