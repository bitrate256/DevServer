package bno.asset.service.logic;

import bno.asset.core.AssetInfo;
import bno.asset.core.AssetType;
import bno.asset.routers.AssetTypeApi;
import bno.asset.util.AssetCodeFormat;
import bno.asset.util.ResourceNotFoundException;
import bno.asset.routers.AssetApi;
import bno.asset.service.AssetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetInfoLogic implements AssetInfoService {

    @Autowired
    private AssetApi assetApi;

    @Autowired
    private AssetTypeApi assetTypeApi;

    // CREATE
    @Override
    public AssetInfo save(AssetInfo assetInfo) {
        AssetCodeFormat format = new AssetCodeFormat();
        String assetTypeCode = assetInfo.getAssetTypeCode().getAssetTypeCode();


//            String pk = format.toAssetCodeFormat(
//                    format.getSeq(), format.getFirstName(), assetInfo.getAssetTypeCode());
//            assetInfo.setAssetNo(pk);
            AssetType assetType = assetTypeApi.findByAssetTypeCode(assetTypeCode);
            if (assetType.getAssetTypeCode().equals(assetTypeCode)) {

                assetInfo.setAssetTypeCode(assetType);
                assetApi.save(assetInfo);
            }
//            assetApi.save(assetInfo);
            return assetInfo;
    }

    // LIST
    @Override
    public List<AssetInfo> findAll() {
        return assetApi.findAll();
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
        assetApi.deleteById(assetNo);
    }

}
