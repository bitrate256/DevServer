package bno.asset.routers;

import bno.asset.core.AssetChangeHist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@EnableJpaRepositories
@Transactional
public interface AssetChangeHistApi extends JpaRepository<AssetChangeHist, String> {
    //

}
