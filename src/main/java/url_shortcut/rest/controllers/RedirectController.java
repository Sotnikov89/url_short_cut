package url_shortcut.rest.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import url_shortcut.rest.domain.Url;
import url_shortcut.rest.services.UrlService;

@RestController
@AllArgsConstructor
@RequestMapping("/redirect")
public class RedirectController {

    private final UrlService urlService;

    @GetMapping("/{code}")
    public ResponseEntity<Void> getRealUrl(@PathVariable String code) {
        Url url = urlService.getUrlByCode(code);
        return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, url.getUrl()).build();
    }
}
