package bno.asset.service;

import bno.asset.core.AssetInfo;

import java.util.List;


public interface AssetInfoService {

    // CREATE
    AssetInfo save(AssetInfo assetInfo);
    // AssetInfo findById(Long id);

    // LIST
    List<AssetInfo> findAll();

    // READ
    AssetInfo findByAssetNo(String assetNo);
    // findById 활용한 검색 기능 구현 필요

    // UPDATE
    void updateById(String assetNo, AssetInfo assetInfo);

    // DELETE
    void deleteByAssetNo(String assetNo);

}
