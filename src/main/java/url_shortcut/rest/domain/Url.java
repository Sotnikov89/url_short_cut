package url_shortcut.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "url", "code", "callsCount"})
@EqualsAndHashCode(of = {"id"})
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String url;
    private String code;
    private long callsCount;
    @ManyToOne
    @JsonIgnore
    private User user;

    public void addCallsCount() {
        this.callsCount = callsCount + 1;
    }
}
