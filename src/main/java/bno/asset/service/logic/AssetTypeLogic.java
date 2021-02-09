package bno.asset.service.logic;

import bno.asset.core.AssetType;
import bno.asset.routers.AssetTypeApi;
import bno.asset.service.AssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetTypeLogic implements AssetTypeService {

    @Autowired
    private AssetTypeApi assetTypeApi;

    @Override
    public void register(AssetType assetType) {
        assetTypeApi.save(assetType);
    }

    @Override
    public AssetType findByAssetTypeCode(AssetType assetType) {
        return assetTypeApi.findByAssetTypeCode(assetType);
    }
}