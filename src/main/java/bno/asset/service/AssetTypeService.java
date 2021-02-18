package bno.asset.service;

import bno.asset.core.AssetType;

import java.util.List;

public interface AssetTypeService {

    // CREATE
    void register(AssetType assetType);

    // LIST
    List<AssetType> findAll();

    // READ
    AssetType findByAssetTypeCode(String assetType);
}
