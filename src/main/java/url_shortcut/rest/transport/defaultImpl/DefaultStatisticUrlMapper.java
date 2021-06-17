package url_shortcut.rest.transport.defaultImpl;

import org.springframework.stereotype.Service;
import url_shortcut.rest.domain.User;
import url_shortcut.rest.dto.DTOStatisticSite;
import url_shortcut.rest.transport.StatisticUrlMapper;

@Service
public class DefaultStatisticUrlMapper implements StatisticUrlMapper {

    @Override
    public DTOStatisticSite UserToDTOStatisticSite(User user) {
        DTOStatisticSite statisticSite = new DTOStatisticSite();
        statisticSite.setSite(user.getSite());
        if (!user.getUrlList().isEmpty()) {
            int siteTotal = user.getUrlList().stream().mapToInt(url -> (int) url.getCallsCount()).sum();
            statisticSite.setTotal(siteTotal);
            user.getUrlList().forEach(url -> {
                DTOStatisticSite.Url dtoUrl = statisticSite.new Url();
                dtoUrl.setPath(url.getUrl());
                dtoUrl.setTotal(url.getCallsCount());
                statisticSite.addUrl(dtoUrl);
            });
        }
        return statisticSite;
    }
}
