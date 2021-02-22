package bno.asset.service.logic;

import bno.asset.core.AssetInfo;
import bno.asset.routers.AssetTypeApi;
import bno.asset.util.ResourceNotFoundException;
import bno.asset.routers.AssetInfoApi;
import bno.asset.service.AssetInfoService;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
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
        String assetTypeCode = assetInfo.getAssetTypeCode().getAssetTypeCode();
        System.out.println("assetTypeCode: "+ assetTypeCode);
        // seq 값 로드 메소드로부터 id값 취득
        String id = this.selectSeq();
        System.out.println("        getId: "+ id);
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
        System.out.println("   .생성된 id값: " + seqNum);
        return seqNum;
    }

    // LIST
    @Override
    public List<AssetInfo> findAll() {
        return assetInfoApi.findAll();
    }

    @Override
    public List<AssetInfo> findAllByAssetModelName(Specification<AssetInfo> withAssetModelName) {
        return null;
    }

    @Override
    public List<AssetInfo> findAllByUserName(Specification<AssetInfo> withUserName) {
        return null;
    }

    // LIST 페이징
    public Page<AssetInfo> findAssetByPageRequest(Pageable pageable) {
        return assetInfoApi.findAll(pageable);
    }

    // LIST  조건검색
//    @Override
//    public List<AssetInfo> findByAssetModelNameLikeAndUserNameLike(String assetModelName, String userName) {
//        return assetInfoApi.findByAssetModelNameLikeAndUserNameLike(assetModelName, userName);
//    }

//    public Specification<AssetInfo> toSpecification() {
//        Specification<AssetInfo> assetModelName = null;
//        Specification<AssetInfo> userName = null;
//
//        if(this.assetModelName != null && !this.assetModelName.isEmpty()) {
//            assetModelName = Specification.where((root, query, builder) ->
//                    builder.like(root.<String>get("assetModelName"),"%"+this.assetModelName+"%"));
//        }
//        if(this.userName != null && !this.userName.isEmpty()) {
//            userName = Specification.where((root, query, builder) ->
//                    builder.like(root.<String>get("userName"),"%"+this.userName+"%"));
//        }
//        return Specification.where(assetModelName).and(userName);
//    }

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
            if(assetInfo.getAssetTypeCode() != null){
                fetchedAssetInfo.get().setAssetTypeCode(assetInfo.getAssetTypeCode());
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
