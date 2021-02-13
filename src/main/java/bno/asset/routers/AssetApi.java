package bno.asset.routers;

import bno.asset.core.AssetInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

// Repository 인터페이스 (DB와 연동을 담당해주는 인터페이스)
// <엔티티오브젝트, 엔티티기본키타입>
@Repository
@EnableJpaRepositories
@Transactional
public interface AssetApi extends JpaRepository<AssetInfo, String> {
    // JpaRepository 클래스를 상속받는다
    // JpaRepository 의 파라미터 인자에 <클래스, Integer를 설정>

}
