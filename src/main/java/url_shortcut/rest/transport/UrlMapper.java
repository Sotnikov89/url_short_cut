package url_shortcut.rest.transport;

import url_shortcut.rest.domain.Url;
import url_shortcut.rest.dto.DTOUrlCode;

public interface UrlMapper {
    DTOUrlCode UrlToDTOUrl(Url url);
}
