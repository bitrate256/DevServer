package bno.asset.service.logic;

import bno.asset.core.AssetInfo;
import bno.asset.core.AssetType;
import bno.asset.routers.AssetTypeApi;
import bno.asset.util.AssetCodeFormat;
import bno.asset.util.ResourceNotFoundException;
import bno.asset.routers.AssetInfoApi;
import bno.asset.service.AssetInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

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
        AssetCodeFormat format = new AssetCodeFormat();
        String assetTypeCode = assetInfo.getAssetTypeCode().getAssetTypeCode();
        AssetType assetType = assetTypeApi.findByAssetTypeCode(assetInfo.getAssetTypeCode().getAssetTypeCode());
        System.out.println(assetType);
        // 사용 로직(시리얼번호 생성)
        if (assetInfo.getAssetNo() == null || assetInfo.getAssetNo().length() == 0) {
            String bno = "BNO_";
            String middleNumber = String.format("%04d",format.getSeq());

            String pk = bno+middleNumber+"_"+assetTypeCode;

            System.out.println(pk);

            assetInfo.setAssetNo(pk);
            assetInfo.setAssetTypeCode(assetType);

            return assetInfoApi.save(assetInfo);
        }
        else {
            throw new RuntimeException();
        }

        //원본
//        ObjectMapper objectMapper = new ObjectMapper();
//
//
//        String pk = format.toAssetCodeFormat(format.getSeq(), format.getFirstName(), assetInfo.getAssetTypeCode());
//        assetInfo.setAssetNo(pk);
//        System.out.println("pk: " + pk);
//        AssetType assetType = assetTypeApi.findByAssetTypeCode(assetTypeCode);
//        System.out.println("assetTypeCode: " + assetTypeCode);
//        if (assetType.getAssetTypeCode().equals(assetTypeCode)) {
//            assetInfo.setAssetTypeCode(assetType);
//            assetInfoApi.save(assetInfo);
//            }
//        return assetInfo;
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
