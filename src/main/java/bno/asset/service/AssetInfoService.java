package bno.asset.service;

import bno.asset.core.AssetInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface AssetInfoService {

    // CREATE
    AssetInfo save(AssetInfo assetInfo);
    String selectSeq() throws Exception;

    // LIST
    List<AssetInfo> findAll();
    // LIST 페이징
    Page<AssetInfo> findAssetByPageRequest(Pageable pageable);

    // READ
    AssetInfo findByAssetNo(String assetNo);

    // UPDATE
    void updateById(String assetNo, AssetInfo assetInfo);
    // UPDATE PATCH 로직 테스트
    int patch(String assetNo, AssetInfo assetInfo);

    // DELETE
    void deleteByAssetNo(String assetNo);

}
