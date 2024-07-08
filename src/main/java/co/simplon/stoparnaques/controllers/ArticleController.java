package co.simplon.stoparnaques.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.stoparnaques.dtos.ArticleCreate;
import co.simplon.stoparnaques.dtos.ArticleLastAdded;
import co.simplon.stoparnaques.dtos.ArticleUpdate;
import co.simplon.stoparnaques.dtos.ArticleView;
import co.simplon.stoparnaques.services.ArticleService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService service;

    public ArticleController(ArticleService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createArticle(
	    @RequestBody @ModelAttribute @Valid ArticleCreate article) {
	service.createArticle(article);
    }

    @GetMapping("/list-articles")
    public List<ArticleView> getAllArticles() {
	return service.getAllArticles();

    }

    @DeleteMapping("/byId/{id}")
    public void deleteArticleById(
	    @PathVariable("id") Long id) {
	service.deleteArticleById(id);
    }

    @GetMapping("/{id}/detail")
    public ArticleView getArticleById(
	    @PathVariable("id") Long id) {
	return service.findProjectedById(id);
    }

    @GetMapping("/articleLastAdded")
    public List<ArticleLastAdded> getTop4LastAdded() {
	return service.getTop4LastAdded();
    }

    @CrossOrigin
    @PatchMapping("/{id}")
    public void updateArticle(
	    @ModelAttribute @Valid @PathVariable("id") Long id,
	    ArticleUpdate article) {
	service.updateArticleById(id, article);
    }

}
