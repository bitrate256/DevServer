package bno.asset.service.logic;

import bno.asset.core.AssetInfo;
import bno.asset.core.AssetType;
import bno.asset.routers.AssetTypeApi;
import bno.asset.util.ResourceNotFoundException;
import bno.asset.routers.AssetInfoApi;
import bno.asset.service.AssetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

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
    // LIST 페이징
    public Page<AssetInfo> findAssetByPageRequest(Pageable pageable) {
        return assetInfoApi.findAll(pageable);
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

    // UPDATE PATCH 테스트
    @Override
    public int patch(String assetNo, AssetInfo assetInfo) {
        Optional<AssetInfo> oAssetInfo = assetInfoApi.findById(assetNo);
        if(oAssetInfo.isPresent()) {
            AssetInfo assetInfos = oAssetInfo.get();
//            if(org.apache.commons.lang3.StringUtils.isNotBlank(assetInfo.getAssetTypeCode()))
//                assetInfos.setAssetTypeCode(assetInfo.getAssetTypeCode());
            if(org.apache.commons.lang3.StringUtils.isNotBlank(assetInfo.getUserName()))
                assetInfos.setUserName(assetInfo.getUserName());
            if(org.apache.commons.lang3.StringUtils.isNotBlank(assetInfo.getAssetModelName()))
                assetInfos.setAssetModelName(assetInfo.getAssetModelName());
            if(org.apache.commons.lang3.StringUtils.isNotBlank(assetInfo.getAssetSerialNo()))
                assetInfos.setAssetSerialNo(assetInfo.getAssetSerialNo());
//            if(org.apache.commons.lang3.StringUtils.isNotBlank(assetInfo.getUseStartDate()))
//                assetInfos.setUseStartDate(assetInfo.getUseStartDate());
            if(org.apache.commons.lang3.StringUtils.isNotBlank(assetInfo.getAssetStat()))
                assetInfos.setAssetStat(assetInfo.getAssetStat());
            if(org.apache.commons.lang3.StringUtils.isNotBlank(assetInfo.getAssetPjtLoc()))
                assetInfos.setAssetPjtLoc(assetInfo.getAssetPjtLoc());
            if(StringUtils.isNotBlank(assetInfo.getEtc()))
                assetInfos.setEtc(assetInfo.getEtc());
            assetInfoApi.save(assetInfo);
            return 1;
        }
        return 0;
    }

    // DELETE
    @Override
    public void deleteByAssetNo(String assetNo) {
        assetInfoApi.deleteById(assetNo);
    }

}
