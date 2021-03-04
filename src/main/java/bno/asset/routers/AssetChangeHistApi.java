package bno.asset.routers;

import bno.asset.core.AssetChangeHist;
import bno.asset.core.AssetInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@EnableJpaRepositories
@Transactional
public interface AssetChangeHistApi extends JpaRepository<AssetChangeHist, String> {

    // 이력조회시 AssetNo 조회
    List<AssetChangeHist> findByAssetNo(AssetInfo assetInfo);
}
