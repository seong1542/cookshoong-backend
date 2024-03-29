package store.cookshoong.www.cookshoongbackend.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 회원등급 엔티티.
 *
 * @author koesnam
 * @since 2023.07.04
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "ranks")
public class Rank {
    @Id
    @Column(name = "rank_code", nullable = false, length = 10)
    private String rankCode;

    @Column(name = "name", nullable = false, length = 10)
    private String name;

    public Rank(String rankCode, String name) {
        this.rankCode = rankCode;
        this.name = name;
    }
}
