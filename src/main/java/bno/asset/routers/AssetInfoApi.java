package bno.asset.routers;

import bno.asset.core.AssetInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

// Repository 인터페이스 (DB와 연동을 담당해주는 인터페이스)
// <엔티티오브젝트, 엔티티기본키타입>
// JPA Specification 기능 사용 위해 JpaSpecificationExecutor<T> 인터페이스 추가 상속
@Repository
@EnableJpaRepositories
@Transactional
public interface AssetInfoApi extends JpaRepository<AssetInfo, String>,
        JpaSpecificationExecutor<AssetInfo> {

    // assetNo 번호 생성 위한 시퀀스 사용
    @Query(value="select lpad(nextval(ASSET_SEQ), 4, 0)", nativeQuery = true)
    String selectSeq();

}
