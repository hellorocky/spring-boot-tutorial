package me.rockywu.ssm.movieapi.controller;

import me.rockywu.ssm.movieapi.pojo.DoubanMovie;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Value("${upload.location}")
    private String location;


    @GetMapping
    public List<DoubanMovie> getAll() {
        List<DoubanMovie> list = new ArrayList<DoubanMovie>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.AUGUST, 30, 0, 0);
        list.add(new DoubanMovie(1, "Rocky", "Stalon", calendar.getTime()));
        list.add(new DoubanMovie(2, "西游记", "吴承恩", calendar.getTime()));
        return list;
    }

    @GetMapping("/{id}")
    public DoubanMovie getOne(@PathVariable int id) {
        if (id==1) {
            return getRocky();
        } else {
            return getXiyouji();
        }
    }

    private DoubanMovie getRocky() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.AUGUST, 30, 0, 0);
        DoubanMovie doubanMovie = new DoubanMovie(1, "Rocky", "Stalon", calendar.getTime());
        return doubanMovie;
    }

    private DoubanMovie getXiyouji() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.AUGUST, 12, 0, 0);
        DoubanMovie doubanMovie = new DoubanMovie(1, "西游记", "吴承恩", calendar.getTime());
        return doubanMovie;
    }

    @PostMapping
    public DoubanMovie createOne(@RequestBody DoubanMovie doubanMovie) {
        doubanMovie.setId(123);
        return doubanMovie;
    }

    @PutMapping("/{id}")
    public DoubanMovie updateOne(@PathVariable int id, @RequestBody DoubanMovie doubanMovie) {
        doubanMovie.setId(123);
        return doubanMovie;
    }
    //http://127.0.0.1:8080/movies/1?delete_reason=123
    @DeleteMapping("/{id}")
    public Map<String, String> deleteOne(@PathVariable int id, HttpServletRequest request,
                         @RequestParam(value = "delete_reason", required = false) String deleteReason) {
        Map<String, String> result = new HashMap<>();
        if (id==1) {
            result.put("message", "id为1的电影被" + request.getRemoteAddr() + "删除, 原因: " + deleteReason);
        } else {
            result.put("message", "只有id为1的电影才可以被删除!");
        }
        return result;
    }

    @PostMapping(value = "/photos/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addPhoto(@PathVariable int id, @RequestParam("photo") MultipartFile imgfile) throws Exception{
        System.out.println("接收到文件ID: " + id + " 文件原始名称为: " + imgfile.getOriginalFilename());

        //保存文件
        FileOutputStream fos = new FileOutputStream(location + imgfile.getOriginalFilename());
        IOUtils.copy(imgfile.getInputStream(), fos);
        fos.close();
    }

    @GetMapping(value = "/photos/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable int id) throws Exception{
        String photoPath = location + id + ".jpg";
        InputStream inputStream = new FileInputStream(photoPath);
        return IOUtils.toByteArray(inputStream);
    }



}
