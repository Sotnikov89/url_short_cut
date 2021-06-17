package url_shortcut.rest.transport.defaultImpl;

import org.springframework.stereotype.Service;
import url_shortcut.rest.domain.Url;
import url_shortcut.rest.dto.DTOUrlCode;
import url_shortcut.rest.transport.UrlMapper;

@Service
public class DefaultUrlMapper implements UrlMapper {

    @Override
    public DTOUrlCode UrlToDTOUrl(Url url) {
        return DTOUrlCode.builder().code(url.getCode()).build();
    }
}
