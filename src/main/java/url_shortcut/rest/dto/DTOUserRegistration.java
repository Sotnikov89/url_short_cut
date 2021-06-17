package url_shortcut.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DTOUserRegistration {
    private boolean registration;
    private String login;
    private String password;
}
