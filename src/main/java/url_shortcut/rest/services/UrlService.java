package url_shortcut.rest.services;

import url_shortcut.rest.domain.Url;

import javax.servlet.http.HttpServletRequest;

public interface UrlService {
    Url save(Url url, HttpServletRequest request);
    Url getUrlByCode(String code);
}
