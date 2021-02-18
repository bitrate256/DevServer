package bno.asset.routers;

import bno.asset.core.AssetInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

// Repository 인터페이스 (DB와 연동을 담당해주는 인터페이스)
// <엔티티오브젝트, 엔티티기본키타입>
@Repository
@EnableJpaRepositories
@Transactional
public interface AssetInfoApi extends JpaRepository<AssetInfo, String> {

    @Query(value="select lpad(nextval(ASSET_SEQ), 4, 0)", nativeQuery = true)
    String selectSeq();
}
