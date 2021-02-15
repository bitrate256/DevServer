package bno.asset.service.logic;

import bno.asset.core.AssetInfo;
import bno.asset.exception.ResourceNotFoundException;
import bno.asset.routers.AssetTypeApi;
import bno.asset.routers.AssetApi;
import bno.asset.service.AssetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssetInfoLogic implements AssetInfoService {

    @Autowired
    private AssetApi assetApi;

    // CREATE
    @Override
    public AssetInfo save(AssetInfo assetInfo) {
        assetApi.save(assetInfo);
        return assetInfo;
    }

    // LIST
    @Override
    public List<AssetInfo> findAll() {
        List<AssetInfo> assetInfos = new ArrayList<>();
        assetApi.findAll().forEach(a->assetInfos.add(a));
        return assetInfos;
    }

    // READ
    @Override
    public AssetInfo findByAssetNo(String assetNo) {
        return assetApi.findById(assetNo).orElseThrow(() ->
                new ResourceNotFoundException("", "", assetNo));
    }

    // UPDATE
    @Override
    public void updateById(String assetNo, AssetInfo assetInfo) {
        AssetInfo a = assetApi.findById(assetNo).orElseThrow(()->
                new ResourceNotFoundException("","",assetNo));
        a.setAssetTypeCode(assetInfo.getAssetTypeCode());
        a.setUserName(assetInfo.getUserName());
        a.setAssetModelName(assetInfo.getAssetModelName());
        a.setAssetSerialNo(assetInfo.getAssetSerialNo());
        a.setUseStartDate(assetInfo.getUseStartDate());
        a.setAssetStat(assetInfo.getAssetStat());
        a.setAssetPjtLoc(assetInfo.getAssetPjtLoc());
        a.setEtc(assetInfo.getEtc());

        assetApi.save(assetInfo);
    }

    // DELETE
    @Override
    public void deleteByAssetNo(String assetNo) {
        assetApi.findById(assetNo);
    }

}
