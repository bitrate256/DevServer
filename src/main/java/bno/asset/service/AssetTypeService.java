package bno.asset.service;

import bno.asset.core.AssetType;

public interface AssetTypeService {

    // CREATE
    void register(AssetType assetType);

    // READ
    AssetType findByAssetTypeCode(String assetType);
}
