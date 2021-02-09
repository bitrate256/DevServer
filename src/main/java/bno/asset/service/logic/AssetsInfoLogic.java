package bno.asset.service.logic;

import bno.asset.core.AssetsInfo;
import bno.asset.routers.AssetTypeApi;
import bno.asset.routers.AssetsApi;
import bno.asset.service.AssetsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetsInfoLogic implements AssetsInfoService {
    //
    @Autowired
    private AssetsApi assetsApi;

    @Autowired
    private AssetTypeApi assetTypeApi;

    @Override
    public void register(AssetsInfo assetsInfo) {
        //
        assetsApi.save(assetsInfo);
    }

    @Override
    public List<AssetsInfo> findAll() {
        return assetsApi.findAll();
    }
}
