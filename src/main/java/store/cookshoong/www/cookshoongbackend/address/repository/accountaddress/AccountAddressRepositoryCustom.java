package store.cookshoong.www.cookshoongbackend.address.repository.accountaddress;

import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;
import store.cookshoong.www.cookshoongbackend.address.model.response.MainAddressResponseDto;

/**
 * 회원과 주소 repository.
 *
 * @author jeongjewan
 * @since 2023.07.04
 */
@NoRepositoryBean
public interface AccountAddressRepositoryCustom {

    List<MainAddressResponseDto> findAccountByAccountId(Long accountId);
}
