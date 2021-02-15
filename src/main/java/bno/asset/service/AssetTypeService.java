package bno.asset.service;

import bno.asset.core.AssetType;

public interface AssetTypeService {

    void register(AssetType assetType);

    AssetType findByAssetTypeCode(String assetType);
}
