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
    public AssetInfo findById(int asset_no) {
        AssetInfo assetInfo = assetApi.findById(asset_no).orElseThrow(()->
                new ResourceNotFoundException("AssetInfo","asset_no",asset_no));
        return assetInfo;
    }

    // READ 2안
    /*
    @Override
    public AssetInfo findByAssetNo(AssetInfo assetInfo) {
        return null;
    }
    */

    // UPDATE
    @Override
    public void updateById(int asset_no, AssetInfo assetInfo) {
        AssetInfo a = assetApi.findById(asset_no).orElseThrow(()->
                new ResourceNotFoundException("AssetInfo","asset_no",asset_no));
        a.setAsset_type_code(assetInfo.getAsset_type_code());
        a.setUser_name(assetInfo.getUser_name());
        a.setAsset_model_name(assetInfo.getAsset_model_name());
        a.setAsset_serial_no(assetInfo.getAsset_serial_no());
        a.setUse_start_date(assetInfo.getUse_start_date());
        a.setAsset_stat(assetInfo.getAsset_stat());
        a.setAsset_pjt_loc(assetInfo.getAsset_pjt_loc());
        a.setEtc(assetInfo.getEtc());

        assetApi.save(assetInfo);
    }

    // DELETE
    @Override
    public void deleteById(int asset_no) {
        assetApi.deleteById(asset_no);
    }

}
