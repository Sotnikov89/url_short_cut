package url_shortcut.rest.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import url_shortcut.rest.domain.User;
import url_shortcut.rest.services.UserService;

@Service("customUserDetailsService")
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getUserByLogin(login).orElseThrow(() -> new UsernameNotFoundException("User doesn't exist"));
        return CustomUser.fromUserToCustomUser(user);
    }
}
