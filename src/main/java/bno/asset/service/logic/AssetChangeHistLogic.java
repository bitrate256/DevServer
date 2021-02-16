package bno.asset.service.logic;

import bno.asset.routers.AssetChangeHistApi;
import bno.asset.core.AssetChangeHist;
import bno.asset.service.AssetChangeHistService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AssetChangeHistLogic implements AssetChangeHistService {

    @Autowired
    private AssetChangeHistApi assetChangeHistApi;

    // CREATE
    @Override
    public AssetChangeHist save(AssetChangeHist assetChangeHist) {
        assetChangeHistApi.save(assetChangeHist);
        return assetChangeHist;
    }

    // LIST
    @Override
    public List<AssetChangeHist> findAll() {
        return null;
    }

    // UPDATE

    // DELETE

}
