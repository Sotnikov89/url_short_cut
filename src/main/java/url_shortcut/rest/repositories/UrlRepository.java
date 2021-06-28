package url_shortcut.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import url_shortcut.rest.domain.Url;

import javax.transaction.Transactional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findUrlByCode(String code);

    @Transactional
    @Modifying
    @Query("update Url u set u.callsCount = u.callsCount+1 where u.code = :code")
    void incrementCallsCount(@Param("code")String code);
}
