package bno.asset.service.logic;

import bno.asset.core.AssetInfo;
import org.springframework.data.jpa.domain.Specification;

// JPA Specification (DB 쿼리 조건 처리)
// 이 프로젝트 에서는 검색 조건을 담당함
public class AssetInfoSpecs {
    // LIST 조건검색 (자산유형)
    // 코드검색 콤보박스용 컬럼 기준으로 검색함
    public static Specification<AssetInfo> withAssetTypeCodeSearch(String assetTypeCodeSearch) {
        return (Specification<AssetInfo>) ((root, query, builder) ->
                builder.like(root.get("assetTypeCodeSearch"), assetTypeCodeSearch)
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
