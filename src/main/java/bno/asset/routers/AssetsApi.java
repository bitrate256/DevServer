package bno.asset.routers;

import bno.asset.core.AssetsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

// <엔티티오브젝트, 엔티티기본키타입>
@Repository
@EnableJpaRepositories
@Transactional
public interface AssetsApi extends JpaRepository<AssetsInfo, String> {
    //

}
