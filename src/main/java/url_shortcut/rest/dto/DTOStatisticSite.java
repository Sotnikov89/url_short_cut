package url_shortcut.rest.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
public class DTOStatisticSite {
    private String site;
    private long total;
    private Set<Url> urls = new HashSet<>();

    public void addUrl(Url url) {
        urls.add(url);
    }

    @Data
    public class Url {
        private String path;
        private long total;
    }
}
