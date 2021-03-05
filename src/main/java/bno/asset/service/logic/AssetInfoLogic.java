package bno.asset.service.logic;

import bno.asset.core.AssetChangeHist;
import bno.asset.core.AssetInfo;
import bno.asset.core.AssetType;
import bno.asset.jpo.AssetJpo;
import bno.asset.routers.AssetChangeHistApi;
import bno.asset.routers.AssetTypeApi;
import bno.asset.util.DateFormat;
import bno.asset.util.ResourceNotFoundException;
import bno.asset.routers.AssetInfoApi;
import bno.asset.service.AssetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

// 비즈니스 로직을 구현하는 클래스
// 서비스 클래스 상속
@Service
public class AssetInfoLogic implements AssetInfoService {

    @Autowired
    private AssetInfoApi assetInfoApi;

    @Autowired
    private AssetTypeApi assetTypeApi;

    @Autowired
    private AssetChangeHistApi assetChangeHistApi;

    // CREATE
    @Override
    public void save(AssetInfo assetInfo) {

        // id값 활용한 일련번호 생성 로직
        // 타입코드 받아옴
        String assetTypeCode = assetInfo.getAssetType().getAssetTypeCode();
        System.out.println("assetTypeCode: "+ assetTypeCode);
        // seq 값 로드 메소드로부터 id값 취득 (49번 라인)
        String id = this.selectSeq();
        System.out.println("        getId: "+ id);
        // assetNo 생성
        String assetNoString = "BNO_" + id + "_" + assetTypeCode;
        // 생성한 assetNoString 를 assetInfo 의 assetNo 에 저장
        assetInfo.setAssetNo(assetNoString);
        assetInfo.setRegDate(DateFormat.today());

        // AssetInfo 최종 저장
        AssetInfo saveConfirm =  assetInfoApi.save(assetInfo);

        // AssetChangHist 신규저장 이력 생성
        AssetChangeHist assetChangeHist = new AssetChangeHist();
        assetChangeHist.setAssetNo(saveConfirm);
        assetChangeHist.setChngRsn("신규생성");
        assetChangeHistApi.save(assetChangeHist);
    }
    // seq 값 로드 메소드
    public String selectSeq() {
        System.out.println(">>>>> selectSeq() 메소드 실행. id 값 취득 <<<<<");
        String seqNum = assetInfoApi.selectSeq();
        System.out.println("   .생성된 id값: " + seqNum);
        return seqNum;
    }

    // LIST
    public Page<AssetInfo> findAllJpo(AssetJpo assetJpo, Pageable pageable) {

        System.out.println("AssetJpo ==> "+assetJpo.toString());
        String assetTypeCode = assetJpo.getAssetTypeCode();
        String assetModelName = assetJpo.getAssetModelName();
        String userName = assetJpo.getUserName();

//      findById(assetTypeCode) Null 체크
        if ( assetTypeCode != null && !"".equals(assetTypeCode)) {
            AssetType assetType = assetTypeApi.findById(assetTypeCode).get();
            // 자산유형
            if( assetType != null && !"".equals(assetType)){
                System.out.print("AssetInfoController findAllByAssetTypeCode :" + assetType + "   ->    ");
                return findAllByAssetTypeCode(AssetInfoSpecs.withAssetTypeCode(assetType), pageable);
            }
            // 모델명
            else if( assetModelName != null && !"".equals(assetModelName)){
                System.out.print("AssetInfoController findAllByAssetModelName :" + assetModelName + "   ->    ");
                return findAllByAssetModelName(AssetInfoSpecs.withAssetModelName(assetModelName), pageable);
            }
            // 사용자명
            else if ( userName != null && !"".equals(userName)){
                System.out.print("AssetInfoController findAllByUserName :" + userName + "   ->    ");
                return findAllByUserName(AssetInfoSpecs.withUserName(userName), pageable);
            }
            // 전체조회
            else {
                return findAll(pageable);
            }
        }
        else {
            // 타입코드 NULL 발생시 다시 조건검색 분기처리 진입
            System.out.println("if (assetTypeCode == null)");
            // 모델명
            if( assetModelName != null && !"".equals(assetModelName)){
                System.out.print("AssetInfoController findAllByAssetModelName :" + assetModelName + "   ->    ");
                return findAllByAssetModelName(AssetInfoSpecs.withAssetModelName(assetModelName), pageable);
            }
            // 사용자명
            else if ( userName != null && !"".equals(userName)){
                System.out.print("AssetInfoController findAllByUserName :" + userName + "   ->    ");
                return findAllByUserName(AssetInfoSpecs.withUserName(userName), pageable);
            }
            // 전체조회
            else {
                return findAll(pageable);
            }
        }
    }

    // LIST 전체조회
    @Override
    public Page<AssetInfo> findAll(Pageable pageable) {
        return assetInfoApi.findAll(pageable);
    }
    // LIST 조건검색 (자산유형)
    @Override
    public Page<AssetInfo> findAllByAssetTypeCode(Specification<AssetInfo> withAssetTypeCodeSearch, Pageable pageable) {
        return assetInfoApi.findAll(Specification.where(withAssetTypeCodeSearch), pageable);
    }
    // LIST 조건검색 (모델명)
    @Override
    public Page<AssetInfo> findAllByAssetModelName(Specification<AssetInfo> withAssetModelName, Pageable pageable) {
        return assetInfoApi.findAll(Specification.where(withAssetModelName), pageable);
    }
    // LIST 조건검색 (사용자명)
    @Override
    public Page<AssetInfo> findAllByUserName(Specification<AssetInfo> withUserName, Pageable pageable) {
        return assetInfoApi.findAll(Specification.where(withUserName), pageable);
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

            // AssetChangHist 업데이트 이력 생성
            AssetInfo updateConfirm =  assetInfoApi.save(fetchedAssetInfo.get());
            AssetChangeHist assetChangeHist = new AssetChangeHist();
            assetChangeHist.setAssetNo(updateConfirm);
            assetChangeHist.setChngRsn("변경사항 반영 완료");
            assetChangeHistApi.save(assetChangeHist);

            // AssetInfo 최종 업데이트
            return assetInfoApi.save(fetchedAssetInfo.get());
        }
        else{
            // 오류 반환
            throw new RuntimeException();
        }
    }

    // DELETE
    @Override
    public void deleteByAssetNo(String assetNo) {
        assetInfoApi.deleteById(assetNo);
    }
}
