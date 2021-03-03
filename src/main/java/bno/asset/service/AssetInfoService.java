package bno.asset.service;

import bno.asset.core.AssetInfo;
import bno.asset.jpo.AssetJpo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;


public interface AssetInfoService {

    // CREATE
    AssetInfo save(AssetInfo assetInfo);
    String selectSeq() throws Exception;

    // JPO DTO
    Page<AssetInfo> findAllJpo(AssetJpo assetType);

    // LIST
    Page<AssetInfo> findAll();
    // LIST 조건검색 (자산유형)
    Page<AssetInfo> findAllByAssetTypeCode(Specification<AssetInfo> withAssetTypeCodeSearch);
    // LIST 조건검색 (모델명)
    Page<AssetInfo> findAllByAssetModelName(Specification<AssetInfo> withAssetModelName);
    // LIST 조건검색 (사용자명)
    Page<AssetInfo> findAllByUserName(Specification<AssetInfo> withUserName);

    // READ
    AssetInfo findByAssetNo(String assetNo);

    // UPDATE
    AssetInfo patchAssetInfo(String assetNo, AssetInfo assetInfo);

    // DELETE
    void deleteByAssetNo(String assetNo);

}
