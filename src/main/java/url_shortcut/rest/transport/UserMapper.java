package url_shortcut.rest.transport;


import url_shortcut.rest.domain.User;
import url_shortcut.rest.dto.DTOUserRegistration;

public interface UserMapper {
    DTOUserRegistration UserToDTOUserRegistration(User user, String password);
}
