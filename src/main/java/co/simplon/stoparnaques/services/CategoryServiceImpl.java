package co.simplon.stoparnaques.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.stoparnaques.dtos.CategoryView;
import co.simplon.stoparnaques.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl
	implements CategoryService {

    private final CategoryRepository categories;

    public CategoryServiceImpl(
	    CategoryRepository categories) {
	this.categories = categories;
    }

    @Override
    public List<CategoryView> findAll() {
	return categories.findAllProjectedBy();
    }

}
