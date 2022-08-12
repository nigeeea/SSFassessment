package assessment.ssfassessment.services;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import assessment.ssfassessment.models.Article;
import assessment.ssfassessment.repositories.NewsRepository;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;

@Service
public class NewsService {

    // @Autowired
    // private NewsRepository newsRepo;
    
    //set URL and API_KEY as instance variables
    private static final String URL = "https://min-api.cryptocompare.com/data/v2/news/";

    @Value("${API_KEY}")
    private String key;

    public List<Article> getArticles(){

        String url = UriComponentsBuilder.fromUriString(URL)
        .queryParam("lang", "EN")
        .queryParam("api_key", key)
        .toUriString();

        //create the get request
        RequestEntity<Void> req = RequestEntity.get(url).build();

        //calling the cryptocompare API
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);

        String payload = resp.getBody();

        //checking the response to verify...
        System.out.println("This is the entire response>>>>>"+resp+"<<<<<<<");
        System.out.println("This is the Status>>>>>>>>"+resp.getStatusCodeValue()+"<<<<<<<<<");
        System.out.println("This is the payload/body>>>>>>"+payload+"<<<<<<<<<");

        //convert the String payload into a JSON Object
        Reader myReader = new StringReader(payload);
        JsonReader myJsonReader = Json.createReader(myReader);
        JsonObject initialJsonObject = myJsonReader.readObject();

        //get the JSONArray "Data"
        JsonArray initialJsonArray = initialJsonObject.getJsonArray("Data");
        
        //Create a List
        List<Article> myList = new ArrayList<>();

        //using a loop, get each object in the array, and pass it into the create method to create a new article with set IVs and 
        // added into the list
        for(int i=0; i<initialJsonArray.size();i++){
            JsonObject anotherObject = initialJsonArray.getJsonObject(i);
            myList.add(Article.create(anotherObject));

        }

        // //create new JsonObject to add fields I want 
        // JsonObjectBuilder myObjectBuilder = Json.createObjectBuilder();
        // JsonObject myObject = myObjectBuilder.add("Message", initialJsonObject.getString("Message")).build();

        

        // Article a = new Article();
        // a.setMessage(myObject.getString("Message"));

        // myList.add(a);

        return myList;
    }

    // public List<Article> saveArticles(){

    //     List<Article> a = new ArrayList<>();
    //     return a;
    // }

    // //getting from redis
    // public Optional<Article> getArticleById(String id){
    //     String result = newsRepo.get(id);
    //     if (null == result)
    //         return Optional.empty();

    //     return Optional.of(Article.create(result));
    // }

    // public Optional<Article> getArticleById(Integer id){
    //     return getArticleById(id.toString());
    // }

    
}
