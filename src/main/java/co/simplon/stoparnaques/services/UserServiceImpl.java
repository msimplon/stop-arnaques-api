package co.simplon.stoparnaques.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.stoparnaques.dtos.UserProfile;
import co.simplon.stoparnaques.repositories.UserRepository;
import co.simplon.stoparnaques.security.SecurityHelper;

@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository users;

    public UserServiceImpl(UserRepository users) {
	this.users = users;
    }

    @Override
    public UserProfile getUserDetails() {
	UserProfile user = null;
	Long authenticatedUserId = SecurityHelper
		.getCurrentAuthenticatedUser();
	if (authenticatedUserId != null) {
	    user = users.getUserById(authenticatedUserId);
	}
	return user;
    }

}
