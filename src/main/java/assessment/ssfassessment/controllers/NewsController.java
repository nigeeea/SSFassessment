package assessment.ssfassessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import assessment.ssfassessment.models.Article;
import assessment.ssfassessment.services.NewsService;

@Controller

@RequestMapping(path = "/")
public class NewsController {

    @Autowired
    private NewsService artSvc;
    

    @GetMapping
    public String displayArticle(
        Model model)
        {

            List<Article> finalList = artSvc.getArticles();
            model.addAttribute("listzxc", finalList);

            return "articlezxc";
        }

    @PostMapping(path = "/")
    public String saveArticles()
    {
        //method to save articles --> create in services 
        return "articlezxc";
    }
    
}
