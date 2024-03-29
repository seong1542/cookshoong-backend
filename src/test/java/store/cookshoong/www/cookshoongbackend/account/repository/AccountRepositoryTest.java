package store.cookshoong.www.cookshoongbackend.account.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import store.cookshoong.www.cookshoongbackend.account.entity.Account;
import store.cookshoong.www.cookshoongbackend.account.entity.AccountsStatus;
import store.cookshoong.www.cookshoongbackend.account.entity.Authority;
import store.cookshoong.www.cookshoongbackend.account.entity.Rank;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 회원 CRU 에 관한 테스트
 *
 * @author koesnam
 * @since 2023.07.04
 */
@DataJpaTest
class AccountRepositoryTest {
    @MockBean
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    TestEntityManager em;

    @Autowired
    AccountRepository accountRepository;

    @Test
    @DisplayName("회원 조회 - 성공")
    void find_account() {
        Rank actual1 = new Rank("VIP", "VIP");
        AccountsStatus actual2 = new AccountsStatus("ACTIVE", "활성");
        Authority actual3 = new Authority("USER", "일반회원");

        Account actual = new Account(actual1, actual2, actual3, "user1", "1234", "유유저",
                "이름이유저래", "user@cookshoong.store", LocalDate.of(1997, 6, 4),
                "01012345678");

        em.persist(actual1);
        em.persist(actual2);
        em.persist(actual3);

        accountRepository.save(actual);

        em.clear();

        Account expect = accountRepository.findByLoginId("user1");

        assertThat(expect.getId()).isEqualTo(actual.getId());
        assertThat(expect.getLoginId()).isEqualTo(actual.getLoginId());
        assertThat(expect.getName()).isEqualTo(actual.getName());
        assertThat(expect.getBirthday()).isEqualTo(actual.getBirthday());
        assertThat(expect.getEmail()).isEqualTo(actual.getEmail());
        assertThat(expect.getNickname()).isEqualTo(actual.getNickname());
        assertThat(expect.getPassword()).isEqualTo(actual.getPassword());
        assertThat(expect.getLastLoginAt()).isEqualTo(actual.getLastLoginAt());
        assertThat(expect.getPhoneNumber()).isEqualTo(actual.getPhoneNumber());
    }

    @Test
    @DisplayName("회원 저장 - 성공")
    void save_account() {
        Rank actual1 = new Rank("VIP", "VIP");
        AccountsStatus actual2 = new AccountsStatus("ACTIVE", "활성");
        Authority actual3 = new Authority("USER", "일반회원");

        Account actual = new Account(actual1, actual2, actual3, "user1", "1234", "유유저",
                "이름이유저래", "user@cookshoong.store", LocalDate.of(1997, 6, 4),
                "01012345678");

        em.persist(actual1);
        em.persist(actual2);
        em.persist(actual3);

        Long accountId = accountRepository.save(actual).getId();
        
        Account expect = em.find(Account.class, accountId);

        assertThat(expect.getId()).isEqualTo(actual.getId());
        assertThat(expect.getLoginId()).isEqualTo(actual.getLoginId());
        assertThat(expect.getName()).isEqualTo(actual.getName());
        assertThat(expect.getBirthday()).isEqualTo(actual.getBirthday());
        assertThat(expect.getEmail()).isEqualTo(actual.getEmail());
        assertThat(expect.getNickname()).isEqualTo(actual.getNickname());
        assertThat(expect.getPassword()).isEqualTo(actual.getPassword());
        assertThat(expect.getLastLoginAt()).isEqualTo(actual.getLastLoginAt());
        assertThat(expect.getPhoneNumber()).isEqualTo(actual.getPhoneNumber());
    }


}
