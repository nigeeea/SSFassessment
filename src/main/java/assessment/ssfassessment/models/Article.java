package assessment.ssfassessment.models;

import java.io.StringReader;

import io.lettuce.core.cluster.PubSubClusterEndpoint;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Article {

    //set instance variables
    private String message;
    private String id;
    private Integer published_on;
    private String title;
    private String url;
    private String imageurl;
    private String body;
    private String tags;
    private String categories;


    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPublished_on() {
        return this.published_on;
    }

    public void setPublished_on(Integer published_on) {
        this.published_on = published_on;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageurl() {
        return this.imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategories() {
        return this.categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public static Article create(JsonObject someJSON){
        Article a = new Article();
        a.setId(someJSON.getString("id"));
        a.setBody(someJSON.getString("body"));
        a.setTitle(someJSON.getString("title"));
        a.setUrl(someJSON.getString("url"));
        a.setImageurl(someJSON.getString("imageurl"));
        a.setTags(someJSON.getString("tags"));
        a.setCategories(someJSON.getString("categories"));
        a.setPublished_on(someJSON.getInt("published_on"));
        return a;
    }

    public static Article create(String jsonString) {
        StringReader strReader = new StringReader(jsonString);
        JsonReader reader = Json.createReader(strReader);
        return create(reader.readObject());
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("id", id)
            .add("title", title)
            .add("body", body)
            .add("published_on", published_on)
            .add("imageurl", imageurl)
            .add("url", url)
            .add("tags", tags)
            .add("categories", categories)
            .build();
    }

    
}
