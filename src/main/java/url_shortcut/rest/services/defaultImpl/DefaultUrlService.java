package url_shortcut.rest.services.defaultImpl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import url_shortcut.rest.domain.Url;
import url_shortcut.rest.domain.User;
import url_shortcut.rest.repositories.UrlRepository;
import url_shortcut.rest.repositories.UserRepository;
import url_shortcut.rest.security.JwtProvider;
import url_shortcut.rest.services.UrlService;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DefaultUrlService implements UrlService {

    private final UrlRepository urlRepository;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Override
    public Url save(Url url, HttpServletRequest request) {
        String login = jwtProvider.getLoginFromRequest(request);
        User user = userRepository.findUserByLogin(login).orElseThrow(() -> new UsernameNotFoundException("User doesn't exist"));
        url.setUser(user);
        url.setCode(UUID.randomUUID().toString());
        return urlRepository.save(url);
    }

    @Override
    public Url getUrlByCode(String code) {
        Url url = urlRepository.findUrlByCode(code);
        urlRepository.incrementCallsCount(code);
        return url;
    }
}

