package bno.asset.service.logic;

import bno.asset.core.AssetInfo;
import org.springframework.data.jpa.domain.Specification;

public class AssetInfoSpecs {

    public static Specification<AssetInfo> withAssetModelName(String assetModelName) {
        return (Specification<AssetInfo>) ((root, query, builder) ->
                builder.like(root.get("assetModelName"), assetModelName)
        );
    }
    public static Specification<AssetInfo> withUserName(String userName) {
        return (Specification<AssetInfo>) ((root, query, builder) ->
                builder.like(root.get("userName"), userName)
        );
    }

//    public enum SearchKey {
//        ASSETMODELNAME("assetModelName"),
//        USERNAME("userName"),
//        LIKESGREATERTHAN("likes");
//
//        private final String value;
//
//        SearchKey(String value) {
//            this.value = value;
//        }
//        public String getValue() {
//            return value;
//        }
//    }
}
