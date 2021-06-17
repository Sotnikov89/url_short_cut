package url_shortcut.rest.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import url_shortcut.rest.domain.User;
import url_shortcut.rest.dto.DTOUserRegistration;
import url_shortcut.rest.services.UserService;
import url_shortcut.rest.transport.UserMapper;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/registration")
public class RegController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public DTOUserRegistration createUser(@RequestBody User user) {
        String newPassword = UUID.randomUUID().toString();
        try {
            user.setPassword(newPassword);
            userService.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userMapper.UserToDTOUserRegistration(user, newPassword);
    }
}
