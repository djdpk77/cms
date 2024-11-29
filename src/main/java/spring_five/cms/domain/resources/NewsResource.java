package spring_five.cms.domain.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_five.cms.domain.models.News;
import spring_five.cms.domain.models.Review;
import spring_five.cms.domain.vo.NewsRequest;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsResource {

    @GetMapping(value = "/{id}")
    public ResponseEntity<News> findOne(@PathVariable String id) {
        return ResponseEntity.ok(new News());
    }

    @GetMapping
    public ResponseEntity<List<News>> findAll() {
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }

    @PostMapping
    public ResponseEntity<News> newNews(NewsRequest news) {
        return new ResponseEntity<>(new News(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNews(@PathVariable("id") String id) {

    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable("id") String id, News news) {
        return new ResponseEntity<>(new News(), HttpStatus.OK);
    }

    @GetMapping(value="/{id}/review/{userId}")
    public ResponseEntity<Review> review(@PathVariable("id") String id, @PathVariable("userId") String userId){
        return ResponseEntity.ok(new Review());
    }

    @GetMapping(value= "/revised")
    public ResponseEntity<List<News>> revisedNews(){
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }

}
