package assessment.ssfassessment.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assessment.ssfassessment.models.Article;
import assessment.ssfassessment.services.NewsService;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

@RestController
@RequestMapping(path = "/news", produces = MediaType.APPLICATION_JSON_VALUE)
public class NewsRESTController {

    // @Autowired
    // private NewsService newsSvc;

    @GetMapping(value = "{aid}")
    public ResponseEntity<String> getArticle(@PathVariable String aid){
        // Optional<Article> opt = artSvc.getArticleById(aid);

        // if(opt.isEmpty()){
        //     JsonObject err = Json.createObjectBuilder()
        //         .add("error", "Id %s not found".formatted(aid))
        //         .build();
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND)
        //     .body(err.toString());
        // }

        // Article article = opt.get();

        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        JsonObject failedObject = objectBuilder.add("error", "Id %s not found".formatted(aid)).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                .body(failedObject.toString());
    }
    
}
