package bno.asset.service;

import bno.asset.core.AssetInfo;
import bno.asset.jpo.AssetJpo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


public interface AssetInfoService {

    // CREATE
    AssetInfo save(AssetInfo assetInfo);
    String selectSeq() throws Exception;

    // LIST
    Page<AssetInfo> findAll(Pageable pageable);
    // LIST 조건검색/페이징을 위한 DTO 메소드
    Page<AssetInfo> findAllJpo(AssetJpo assetType, Pageable pageable);
    // LIST 조건검색 (자산유형)
    Page<AssetInfo> findAllByAssetTypeCode(Specification<AssetInfo> withAssetTypeCodeSearch, Pageable pageable);
    // LIST 조건검색 (모델명)
    Page<AssetInfo> findAllByAssetModelName(Specification<AssetInfo> withAssetModelName, Pageable pageable);
    // LIST 조건검색 (사용자명)
    Page<AssetInfo> findAllByUserName(Specification<AssetInfo> withUserName, Pageable pageable);

    // READ
    AssetInfo findByAssetNo(String assetNo);

    // UPDATE
    AssetInfo patchAssetInfo(String assetNo, AssetInfo assetInfo);

    // DELETE
    void deleteByAssetNo(String assetNo);


}
