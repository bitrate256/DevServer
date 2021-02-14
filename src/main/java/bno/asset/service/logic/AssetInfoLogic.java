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

    // READ 1안
    @Override
    public AssetInfo findByAssetNo(int assetNo) {
        AssetInfo assetInfo = assetApi.findByAssetNo(assetNo).orElseThrow(()->
                new ResourceNotFoundException("AssetInfo","assetNo",assetNo));
        return assetInfo;
    }

    // UPDATE
    @Override
    public void updateById(int assetNo, AssetInfo assetInfo) {
        AssetInfo a = assetApi.findByAssetNo(assetNo).orElseThrow(()->
                new ResourceNotFoundException("AssetInfo","assetNo",assetNo));
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
    public void deleteByAssetNo(int assetNo) {
        assetApi.deleteByAssetNo(assetNo);
    }

}
