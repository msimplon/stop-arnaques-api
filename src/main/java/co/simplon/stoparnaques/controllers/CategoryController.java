package co.simplon.stoparnaques.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.stoparnaques.dtos.CategoryView;
import co.simplon.stoparnaques.services.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
	this.service = service;
    }

    @GetMapping
    public List<CategoryView> findAll() {
	return service.findAll();
    }

}
