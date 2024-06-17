package co.simplon.stoparnaques.services;

import java.util.List;

import co.simplon.stoparnaques.dtos.ArticleCreate;
import co.simplon.stoparnaques.dtos.ArticleLastAdded;
import co.simplon.stoparnaques.dtos.ArticleUpdate;
import co.simplon.stoparnaques.dtos.ArticleView;

public interface ArticleService {

    List<ArticleView> getAllArticles();

    void deleteArticleById(Long id);

    void createArticle(ArticleCreate article);

    void updateArticleById(Long id, ArticleUpdate inputs);

    ArticleView findProjectedById(Long id);

//    Optional<ArticleView> findProjectedById(Long id);

    List<ArticleLastAdded> getTop4LastAdded();

}

//OPTINAL return qlq chose d'optienne '