package co.simplon.stoparnaques.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.stoparnaques.dtos.CategoryView;
import co.simplon.stoparnaques.entities.Category;

@Repository
public interface CategoryRepository
	extends JpaRepository<Category, Long> {

    List<CategoryView> findAllProjectedBy();
}
