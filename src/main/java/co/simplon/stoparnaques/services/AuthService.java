package co.simplon.stoparnaques.services;

import co.simplon.stoparnaques.dtos.TokenInfo;
import co.simplon.stoparnaques.dtos.UserCreate;

public interface AuthService {

    void signUp(UserCreate inputs);

    TokenInfo signIn(UserCreate inputs);

    void verifyUserRegistration(String confirmationToken);

}
