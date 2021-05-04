package es.cyrus.dev.restexample;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.google.gson.Gson; 

@RestController
@RequestMapping("/demo")
public class DemoController {

    public DemoController() {
    }

    @GetMapping("/{id}")
    public MyData getData(@PathVariable("id") Integer Id) {

        String s = " https://jsonplaceholder.typicode.com/posts/" + Id.toString();
        String result = HttpUtil.get(s);
        if (result == null) {
            // Empty
            return new MyData();
        }

        Gson gson = new Gson();  
        return gson.fromJson(result, MyData.class);  
    }

    @PutMapping("/{id}")
    public MyData putData(@PathVariable("id") Integer Id) {

        String s = " https://jsonplaceholder.typicode.com/posts/" + Id.toString();
        String result = HttpUtil.get(s);
        if (result == null) {
            // Empty
            return new MyData();
        }

        Gson gson = new Gson();  
        return gson.fromJson(result, MyData.class);  
    }

    @PostMapping("")
    public MyData postData(@RequestBody String myParam) {

        String s = " https://jsonplaceholder.typicode.com/posts/" + myParam;
        String result = HttpUtil.get(s);
        if (result == null) {
            // Empty
            return new MyData();
        }

        Gson gson = new Gson();  
        return gson.fromJson(result, MyData.class);  
    }

    @DeleteMapping("")
    public MyData deleteData(@RequestBody String myParam) {

        String s = " https://jsonplaceholder.typicode.com/posts/" + myParam;
        String result = HttpUtil.get(s);
        if (result == null) {
            // Empty
            return new MyData();
        }

        Gson gson = new Gson();  
        return gson.fromJson(result, MyData.class);  
    }

}
