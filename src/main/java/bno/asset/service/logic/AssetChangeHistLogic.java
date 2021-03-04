package bno.asset.service.logic;

import bno.asset.core.AssetInfo;
import bno.asset.routers.AssetChangeHistApi;
import bno.asset.core.AssetChangeHist;
import bno.asset.service.AssetChangeHistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssetChangeHistLogic implements AssetChangeHistService {

    @Autowired
    private AssetChangeHistApi assetChangeHistApi;

    // CREATE
    @Override
    public AssetChangeHist register(AssetChangeHist assetChangeHist) {
        assetChangeHistApi.save(assetChangeHist);
        return assetChangeHist;
    }

    // LIST
    @Override
    public List<AssetChangeHist> retrieveAll() {
        return assetChangeHistApi.findAll();
    }

    // 이력조회시 AssetNo 조회
    @Override
    public List<AssetChangeHist> retrieveByAssetNo(AssetInfo assetInfo) {
        return assetChangeHistApi.findByAssetNo(assetInfo);
    }
}
