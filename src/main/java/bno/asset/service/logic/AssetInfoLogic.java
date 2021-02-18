package bno.asset.service.logic;

import bno.asset.core.AssetInfo;
import bno.asset.core.AssetType;
import bno.asset.routers.AssetTypeApi;
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
        // seq 값 로드 메소드로부터 id값 취득
        String id = this.selectSeq();
        System.out.println("       getId: "+ id);
        // assetNo 생성
        String assetNoString = "BNO_" + id + "_" + assetTypeCode;
        // 생성한 assetNoString 를 assetInfo 의 assetNo 에 저장
        assetInfo.setAssetNo(assetNoString);
        return assetInfoApi.save(assetInfo);
    }

    // seq 값 로드
    public String selectSeq() {
        System.out.println(">>>>> selectSeq() 메소드 실행. id 값 취득 <<<<<");
        String seqNum = assetInfoApi.selectSeq();
        System.out.println("   생성된 id값: " + seqNum);
        return seqNum;
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
