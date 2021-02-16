package bno.asset.service;

import bno.asset.core.AssetInfo;

import java.util.List;


public interface AssetInfoService {

    // CREATE
    AssetInfo save(AssetInfo assetInfo);

    // LIST
    List<AssetInfo> findAll();

    // READ
    AssetInfo findByAssetNo(String assetNo);

    // UPDATE
    void updateById(String assetNo, AssetInfo assetInfo);

    // DELETE
    void deleteByAssetNo(String assetNo);

}
