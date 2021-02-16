package bno.asset.service.logic;

import bno.asset.core.AssetType;
import bno.asset.routers.AssetTypeApi;
import bno.asset.service.AssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class AssetTypeLogic implements AssetTypeService {

    @Autowired
    private AssetTypeApi assetTypeApi;

    // CREATE
    @Override
    public void register(AssetType assetType) {

        assetType.setNo(UUID.randomUUID().toString());
        assetTypeApi.save(assetType);
    }

    // READ
    @Override
    public AssetType findByAssetTypeCode(String assetType) {

        return assetTypeApi.findByAssetTypeCode(assetType);
    }

}
