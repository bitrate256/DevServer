package bno.asset.routers;

import bno.asset.core.AssetInfo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

// Repository 인터페이스 (DB와 연동을 담당해주는 인터페이스)
// <엔티티오브젝트, 엔티티기본키타입>
@Repository
@EnableJpaRepositories
@Transactional
public interface AssetInfoApi extends JpaRepository<AssetInfo, String>,
        JpaSpecificationExecutor<AssetInfo> {

    @Query(value="select lpad(nextval(ASSET_SEQ), 4, 0)", nativeQuery = true)
    String selectSeq();

    // READ ( 모델명 assetModelName / 사용자 userName )
    @Query("SELECT ai FROM AssetInfo ai WHERE (" +
            ":assetModelName is null or ai.assetModelName = :assetModelName)"
            + "and (:userName is null" + " or ai.userName = :userName)")
    List<AssetInfo> findByAssetModelNameLikeAndUserNameLike(
            @Param("assetModelName") String assetModelName,
            @Param("userName") String userName
    );
}
