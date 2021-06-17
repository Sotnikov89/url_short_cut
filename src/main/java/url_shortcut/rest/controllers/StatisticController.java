package url_shortcut.rest.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import url_shortcut.rest.domain.User;
import url_shortcut.rest.dto.DTOStatisticSite;
import url_shortcut.rest.security.JwtProvider;
import url_shortcut.rest.services.UserService;
import url_shortcut.rest.transport.StatisticUrlMapper;

import javax.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
@RequestMapping("/statistic")
public class StatisticController {

    private final UserService userService;
    private final JwtProvider jwtProvider;
    private final StatisticUrlMapper statisticUrlMapper;

    @GetMapping
    public DTOStatisticSite getStatisticByToken(HttpServletRequest request) {
        User user = userService.getUserByLogin(jwtProvider.getLoginFromRequest(request)).orElseThrow(() -> new UsernameNotFoundException("User doesn't exist"));
        return statisticUrlMapper.UserToDTOStatisticSite(user);
    }
}
