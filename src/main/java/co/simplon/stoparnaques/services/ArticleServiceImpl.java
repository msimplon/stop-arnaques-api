package co.simplon.stoparnaques.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import co.simplon.stoparnaques.dtos.ArticleCreate;
import co.simplon.stoparnaques.dtos.ArticleLastAdded;
import co.simplon.stoparnaques.dtos.ArticleUpdate;
import co.simplon.stoparnaques.dtos.ArticleView;
import co.simplon.stoparnaques.entities.Article;
import co.simplon.stoparnaques.entities.Category;
import co.simplon.stoparnaques.repositories.ArticleRepository;
import co.simplon.stoparnaques.repositories.CategoryRepository;

// dans cette class changer le artcileview en optional voir code frank

@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repo;

    private final CategoryRepository categories;

    @Value("${stoparnaques-api.uploads.location}")
    private String uploadDir;

    public ArticleServiceImpl(ArticleRepository repo,
	    CategoryRepository categories) {
	this.repo = repo;
	this.categories = categories;

    }

    @Override
    public List<ArticleView> getAllArticles() {
	return repo.findAllProjectedBy();
    }

    @Override
    @Transactional(readOnly = false)
    public void createArticle(ArticleCreate inputs) {
	Article article = new Article();
	article.setTitle(inputs.getTitle());
	article.setSubTitle(inputs.getSubTitle());
	article.setEditor(inputs.getEditor());
	article.setDescription(inputs.getDescription());
	article.setIntroduction(inputs.getIntroduction());

	if ((inputs.getImageUrl() != null)) {
	    MultipartFile file = inputs.getImageUrl();
	    String baseName = UUID.randomUUID().toString();
	    String imageName = baseName + inputs
		    .getImageUrl().getOriginalFilename();
	    article.setImageUrl(imageName);
	    store(file, imageName);
	}
	article.setDate(inputs.getDate());
	LocalDateTime createdAt = LocalDateTime.now();
	article.setCreatedAt(createdAt);
	@SuppressWarnings("deprecation")
	Category category = categories
		.getById(inputs.getCategoryId());
	article.setCategory(category);
	repo.save(article);
    }

    @Override
    @Transactional
    public void updateArticleById(Long id,
	    ArticleUpdate inputs) {
	Article article = repo.findById(id).get();
	article.setTitle(inputs.getTitle());
	article.setSubTitle(inputs.getSubTitle());
	article.setEditor(inputs.getEditor());
	article.setDescription(inputs.getDescription());
	article.setIntroduction(inputs.getIntroduction());

	if ((inputs.getImageUrl() != null)) {
	    MultipartFile file = inputs.getImageUrl();
	    String baseName = UUID.randomUUID().toString();
	    String imageName = baseName + inputs
		    .getImageUrl().getOriginalFilename();
	    article.setImageUrl(imageName);
	    store(file, imageName);
	}
	article.setDate(inputs.getDate());
	@SuppressWarnings("deprecation")
	Category category = categories
		.getById(inputs.getCategoryId());
	article.setCategory(category);
	repo.save(article);
    }

    private void store(MultipartFile file,
	    String fileName) {
	Path uploadPath = Paths.get(uploadDir);
	Path target = uploadPath.resolve(fileName);
	try (InputStream in = file.getInputStream()) {
	    Files.copy(in, target,
		    StandardCopyOption.REPLACE_EXISTING);
	} catch (IOException ex) {
	    throw new RuntimeException(ex);
	}
    }

    @Override
    @Transactional
    public void deleteArticleById(Long id) {
	repo.deleteById(id);
    }

    @Override
    public ArticleView findProjectedById(Long id) {
	return repo.findProjectedById(id).get();
    }

    @Override
    public List<ArticleLastAdded> getTop4LastAdded() {
	return repo.findTop4ByOrderByCreatedAtDesc();
    }

}
