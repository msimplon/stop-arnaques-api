package co.simplon.stoparnaques.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.stoparnaques.dtos.TokenInfo;
import co.simplon.stoparnaques.dtos.UserCreate;
import co.simplon.stoparnaques.services.AuthService;
import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(
	    @RequestBody @Valid UserCreate inputs) {
	service.signUp(inputs);

    }

    @PostMapping("/sign-in")
    public TokenInfo signIn(
	    @RequestBody UserCreate inputs) {
	return service.signIn(inputs);
    }

    @GetMapping("/verify")
    public void verifyUserRegistration(
	    @RequestParam("code") String confirmationToken) {
	service.verifyUserRegistration(confirmationToken);
    }

}
