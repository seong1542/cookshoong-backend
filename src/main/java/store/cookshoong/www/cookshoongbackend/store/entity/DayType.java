package store.cookshoong.www.cookshoongbackend.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 요일 타입 엔티티.
 *
 * @author seungyeon
 * @since 2023.07.04
 */
@Getter
@Entity
@Table(name = "day_types")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DayType {
    @Id
    @Column(name = "day_code", nullable = false, length = 3)
    private String dayCode;

    @Column(nullable = false, length = 3)
    private String description;

}
