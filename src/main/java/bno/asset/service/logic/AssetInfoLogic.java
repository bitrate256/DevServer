package bno.asset.service.logic;

import bno.asset.core.AssetInfo;
import bno.asset.core.AssetType;
import bno.asset.routers.AssetTypeApi;
import bno.asset.util.AssetCodeFormat;
import bno.asset.util.ResourceNotFoundException;
import bno.asset.routers.AssetInfoApi;
import bno.asset.service.AssetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 비즈니스 로직을 구현하는 클래스
// 서비스 클래스 상속
@Service
public class AssetInfoLogic implements AssetInfoService {

    @Autowired
    private AssetInfoApi assetInfoApi;

    @Autowired
    private AssetTypeApi assetTypeApi;

    // CREATE
    @Override
    public AssetInfo save(AssetInfo assetInfo) {

        // id값 활용한 일련번호 생성 로직
        // 타입코드 받아옴
        String assetTypeCode = assetInfo.getAssetTypeCode().getAssetTypeCode();
        AssetType assetType = assetTypeApi.findByAssetTypeCode(assetInfo.getAssetTypeCode().getAssetTypeCode());
        System.out.println("   assetType: "+ assetType);
        // id값 받아옴
        Long id = assetInfo.getId();
        System.out.println("       getId: "+ id);
        String middleNumber = String.format("%04d", id);
        System.out.println("middleNumber: "+ middleNumber);
        // assetNo 생성
        String assetNoString = "BNO_" + middleNumber + "_" + assetTypeCode;

        // 생성한 assetNoString를 assetInfo의 assetNo에 저장
        assetInfo.setAssetNo(assetNoString);
        return assetInfoApi.save(assetInfo);
    }

    // LIST
    @Override
    public List<AssetInfo> findAll() {
        return assetInfoApi.findAll();
    }

    // READ
    @Override
    public AssetInfo findByAssetNo(String assetNo) {
        return assetInfoApi.findById(assetNo).orElseThrow(() ->
                new ResourceNotFoundException("", "", assetNo));
    }

    // UPDATE
    @Override
    public void updateById(String assetNo, AssetInfo assetInfo) {
        AssetInfo a = assetInfoApi.findById(assetNo).orElseThrow(()->
                new ResourceNotFoundException("","",assetNo));
        a.setAssetTypeCode(assetInfo.getAssetTypeCode());
        a.setUserName(assetInfo.getUserName());
        a.setAssetModelName(assetInfo.getAssetModelName());
        a.setAssetSerialNo(assetInfo.getAssetSerialNo());
        a.setUseStartDate(assetInfo.getUseStartDate());
        a.setAssetStat(assetInfo.getAssetStat());
        a.setAssetPjtLoc(assetInfo.getAssetPjtLoc());
        a.setEtc(assetInfo.getEtc());

        assetInfoApi.save(assetInfo);
    }

    // DELETE
    @Override
    public void deleteByAssetNo(String assetNo) {
        assetInfoApi.deleteById(assetNo);
    }

}
