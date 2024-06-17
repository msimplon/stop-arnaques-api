package co.simplon.stoparnaques.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.stoparnaques.dtos.ArticleLastAdded;
import co.simplon.stoparnaques.dtos.ArticleView;
import co.simplon.stoparnaques.entities.Article;

@Repository
public interface ArticleRepository
	extends JpaRepository<Article, Long> {

    Optional<Article> findByTitleIgnoreCase(String title);

    Optional<ArticleView> findProjectedById(Long id);

    List<ArticleView> findAllProjectedBy();

    List<ArticleLastAdded> findTop4ByOrderByCreatedAtDesc();

}
