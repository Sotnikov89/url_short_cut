package url_shortcut.rest.services;

import url_shortcut.rest.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserByLogin(String login);
    User save(User user) throws Exception;
}

