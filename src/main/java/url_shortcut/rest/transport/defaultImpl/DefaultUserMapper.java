package url_shortcut.rest.transport.defaultImpl;

import org.springframework.stereotype.Service;
import url_shortcut.rest.domain.User;
import url_shortcut.rest.dto.DTOUserRegistration;
import url_shortcut.rest.transport.UserMapper;

@Service
public class DefaultUserMapper implements UserMapper {

    @Override
    public DTOUserRegistration UserToDTOUserRegistration(User user, String password) {
        DTOUserRegistration dtoUser = new DTOUserRegistration();
        if (user.getId() != 0) {
            dtoUser.setRegistration(true);
            dtoUser.setLogin(user.getLogin());
            dtoUser.setPassword(password);
        } else {
            dtoUser.setRegistration(false);
        }
        return dtoUser;
    }
}
