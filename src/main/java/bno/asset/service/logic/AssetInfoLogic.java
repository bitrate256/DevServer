package bno.asset.service.logic;

import bno.asset.core.AssetInfo;
import bno.asset.routers.AssetTypeApi;
import bno.asset.util.ResourceNotFoundException;
import bno.asset.routers.AssetInfoApi;
import bno.asset.service.AssetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        String assetTypeCode = assetInfo.getAssetType().getAssetTypeCode();
        System.out.println("assetTypeCode: "+ assetTypeCode);
        // seq 값 로드 메소드로부터 id값 취득
        String id = this.selectSeq();
        System.out.println("        getId: "+ id);
        // assetNo 생성
        String assetNoString = "BNO_" + id + "_" + assetTypeCode;
        // 생성한 assetNoString 를 assetInfo 의 assetNo 에 저장
        assetInfo.setAssetNo(assetNoString);
        // 코드검색 콤보박스용 컬럼에 코드값 저장
//        assetInfo.setAssetTypeCodeSearch(assetTypeCode);
        return assetInfoApi.save(assetInfo);
    }

    // seq 값 로드
    public String selectSeq() {
        System.out.println(">>>>> selectSeq() 메소드 실행. id 값 취득 <<<<<");
        String seqNum = assetInfoApi.selectSeq();
        System.out.println("   .생성된 id값: " + seqNum);
        return seqNum;
    }

    // LIST
    @Override
    public List<AssetInfo> findAll() {
        return assetInfoApi.findAll();
    }
    // LIST 조건검색 (자산유형)
    @Override
    public List<AssetInfo> findAllByAssetTypeCode(Specification<AssetInfo> withAssetTypeCodeSearch) {
        return assetInfoApi.findAll(Specification.where(withAssetTypeCodeSearch));
    }
    // LIST 조건검색 (모델명)
    @Override
    public List<AssetInfo> findAllByAssetModelName(Specification<AssetInfo> withAssetModelName) {
        return assetInfoApi.findAll(Specification.where(withAssetModelName));
    }
    // LIST 조건검색 (사용자명)
    @Override
    public List<AssetInfo> findAllByUserName(Specification<AssetInfo> withUserName) {
        return assetInfoApi.findAll(Specification.where(withUserName));
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

    // UPDATE (PATCH)
    @Override
    public AssetInfo patchAssetInfo(String assetNo, AssetInfo assetInfo){
        final Optional<AssetInfo> fetchedAssetInfo = assetInfoApi.findById(assetNo);
        if(fetchedAssetInfo.isPresent()){
            if(assetInfo.getAssetNo() != null){
                fetchedAssetInfo.get().setAssetNo(assetInfo.getAssetNo());
            }
            if(assetInfo.getAssetType() != null){
                fetchedAssetInfo.get().setAssetType(assetInfo.getAssetType());
            }
            if(assetInfo.getUserName() != null){
                fetchedAssetInfo.get().setUserName(assetInfo.getUserName());
            }
            if(assetInfo.getAssetModelName() != null){
                fetchedAssetInfo.get().setAssetModelName(assetInfo.getAssetModelName());
            }
            if(assetInfo.getAssetSerialNo() != null){
                fetchedAssetInfo.get().setAssetSerialNo(assetInfo.getAssetSerialNo());
            }
            if(assetInfo.getUseStartDate() != null){
                fetchedAssetInfo.get().setUseStartDate(assetInfo.getUseStartDate());
            }
            if(assetInfo.getAssetStat() != null){
                fetchedAssetInfo.get().setAssetStat(assetInfo.getAssetStat());
            }
            if(assetInfo.getAssetPjtLoc() != null){
                fetchedAssetInfo.get().setAssetPjtLoc(assetInfo.getAssetPjtLoc());
            }
            if(assetInfo.getEtc() != null){
                fetchedAssetInfo.get().setEtc(assetInfo.getEtc());
            }
            return assetInfoApi.save(fetchedAssetInfo.get());
        }
        else{
            return null;
        }
    }

    // DELETE
    @Override
    public void deleteByAssetNo(String assetNo) {
        assetInfoApi.deleteById(assetNo);
    }


}
