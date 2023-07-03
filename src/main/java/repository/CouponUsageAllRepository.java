package repository;

import entity.CouponUsageAll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CouponUsageAllRepository extends JpaRepository<CouponUsageAll, Long>, JpaSpecificationExecutor<CouponUsageAll> {

}