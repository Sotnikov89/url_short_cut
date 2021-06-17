package url_shortcut.rest.transport;

import url_shortcut.rest.domain.User;
import url_shortcut.rest.dto.DTOStatisticSite;

public interface StatisticUrlMapper {
    DTOStatisticSite UserToDTOStatisticSite(User user);
}
