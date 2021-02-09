package bno.asset.service.logic;

import bno.asset.core.AssetInfo;
import bno.asset.routers.AssetTypeApi;
import bno.asset.routers.AssetApi;
import bno.asset.service.AssetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetInfoLogic implements AssetInfoService {
    //
    @Autowired
    private AssetApi assetApi;

    @Autowired
    private AssetTypeApi assetTypeApi;

    @Override
    public void register(AssetInfo assetInfo) {
        //
        assetApi.save(assetInfo);
    }

    @Override
    public List<AssetInfo> findAll() {
        return assetApi.findAll();
    }
}
