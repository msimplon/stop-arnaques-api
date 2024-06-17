package co.simplon.itp3.stoparnaques;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import co.simplon.stoparnaques.controllers.UserController;

@TestConfiguration
class ControllerMocks {

    @Bean
    UserController accountController() {
	return Mockito.mock(UserController.class);
    }

}