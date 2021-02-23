package bno.asset.service.logic;

import bno.asset.core.AssetInfo;
import org.springframework.data.jpa.domain.Specification;

// JPA Specification (DB 쿼리 조건 처리)
// 이 프로젝트 에서는 검색 조건 담당한다
public class AssetInfoSpecs {
    // LIST 조건검색 (자산유형)
    public static Specification<AssetInfo> withAssetTypeCode(String assetTypeCode) {
        return (Specification<AssetInfo>) ((root, query, builder) ->
                builder.like(root.get("assetTypeCode"), assetTypeCode)
        );
    }
    // LIST 조건검색 (모델명)
    public static Specification<AssetInfo> withAssetModelName(String assetModelName) {
        return (Specification<AssetInfo>) ((root, query, builder) ->
                builder.like(root.get("assetModelName"), "%" + assetModelName + "%")
        );
    }
    // LIST 조건검색 (사용자명)
    public static Specification<AssetInfo> withUserName(String userName) {
        return (Specification<AssetInfo>) ((root, query, builder) ->
                builder.like(root.get("userName"), "%" + userName + "%")
        );
    }
}
