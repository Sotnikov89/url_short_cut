package url_shortcut.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import url_shortcut.rest.domain.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findUrlByCode(String code);
}
