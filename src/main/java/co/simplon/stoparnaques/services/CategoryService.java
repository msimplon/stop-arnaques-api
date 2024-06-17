package co.simplon.stoparnaques.services;

import java.util.List;

import co.simplon.stoparnaques.dtos.CategoryView;

public interface CategoryService {

    List<CategoryView> findAll();

}
