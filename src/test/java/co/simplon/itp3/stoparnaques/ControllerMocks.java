package co.simplon.itp3.stoparnaques;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import co.simplon.stoparnaques.controllers.ArticleController;
import co.simplon.stoparnaques.controllers.CategoryController;
import co.simplon.stoparnaques.controllers.DisputeController;
import co.simplon.stoparnaques.controllers.FormController;
import co.simplon.stoparnaques.controllers.UserController;

//ici c'est comme si en faisait des requetes HTTP on va lui demander d'exécuter des requetes avec un verbe, une url. Le but c'est de voir si je peuc acceder ou pas a à la méthode de mon controller
//tout ca sera dc simuler 
//
@TestConfiguration
class ControllerMocks {

    @Bean
    ArticleController ArticleController() {
	return Mockito.mock(ArticleController.class);
    }

    @Bean
    CategoryController CategoryController() {
	return Mockito.mock(CategoryController.class);
    }

    @Bean
    DisputeController DisputeController() {
	return Mockito.mock(DisputeController.class);
    }

    @Bean
    CategoryController categoryController() {
	return Mockito.mock(CategoryController.class);
    }

    @Bean
    FormController FormController() {
	return Mockito.mock(FormController.class);
    }

    @Bean
    UserController userController() {
	return Mockito.mock(UserController.class);
    }
}