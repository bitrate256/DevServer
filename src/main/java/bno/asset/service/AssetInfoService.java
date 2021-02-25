package bno.asset.service;

import bno.asset.core.AssetInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


public interface AssetInfoService {

    // CREATE
    AssetInfo save(AssetInfo assetInfo);
    String selectSeq() throws Exception;

    // LIST
    List<AssetInfo> findAll();
//    Page<AssetInfo> findAll(Pageable pageable, Integer totalElements);
    // LIST 조건검색 (자산유형)
    List<AssetInfo> findAllByAssetTypeCode(Specification<AssetInfo> withAssetTypeCodeSearch);
//    Page<AssetInfo> findAllByAssetTypeCode(Specification<AssetInfo> withAssetTypeCodeSearch, Pageable pageable, Integer totalElements);
    // LIST 조건검색 (모델명)
    List<AssetInfo> findAllByAssetModelName(Specification<AssetInfo> withAssetModelName);
//    Page<AssetInfo> findAllByAssetModelName(Specification<AssetInfo> withAssetModelName, Pageable pageable, Integer totalElements);
    // LIST 조건검색 (사용자명)
    List<AssetInfo> findAllByUserName(Specification<AssetInfo> withUserName);
//    Page<AssetInfo> findAllByUserName(Specification<AssetInfo> withUserName, Pageable pageable, Integer totalElements);

    // LIST 페이징
//    Pageable pageable = PageRequest.of(1, 10, new Sort(Direction.DESC, ""));
    Page<AssetInfo> findAssetByPageRequest(Pageable pageable);

    // READ
    AssetInfo findByAssetNo(String assetNo);

    // UPDATE
    AssetInfo patchAssetInfo(String assetNo, AssetInfo assetInfo);

    // DELETE
    void deleteByAssetNo(String assetNo);

    // YYYY-MM-DD
}
