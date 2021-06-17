package url_shortcut.rest.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import url_shortcut.rest.domain.Url;
import url_shortcut.rest.dto.DTOUrlCode;
import url_shortcut.rest.services.UrlService;
import url_shortcut.rest.transport.UrlMapper;

import javax.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
@RequestMapping("/convert")
public class ConvertController {

    private final UrlService urlService;
    private final UrlMapper urlMapper;

    @PostMapping
    public DTOUrlCode createUrlCode(@RequestBody Url url, HttpServletRequest request) {
        urlService.save(url, request);
        return urlMapper.UrlToDTOUrl(url);
    }
}
