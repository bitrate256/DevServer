package bno.asset.controller;

import bno.asset.core.AssetInfo;
import bno.asset.service.logic.AssetInfoSpecs;
import bno.asset.service.AssetInfoService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
// Controller 클래스
// 클라이언트로 부터 요청을 받아 해당 처리를 한 후 요청의 응답을 클라이언트에 보냄.
public class AssetInfoController {

    @Autowired
    private final AssetInfoService assetInfoService;

    @PostMapping("/")
    public String home() {
        return "";
    }

    // CREATE
    // POST 자산 등록
    @PostMapping(value = "/asset/create")
    public ResponseEntity<AssetInfo> create(@RequestBody AssetInfo assetInfo) {
        System.out.println("AssetInfo CREATE 값 확인      ========>    "+assetInfo.toString());
        return new ResponseEntity<AssetInfo>(assetInfoService.save(assetInfo), HttpStatus.OK);
    }

    // LIST
    // POST 자산 전체목록 조회
    @GetMapping(value = "/asset")
    public ResponseEntity<List<AssetInfo>> getAllasset() {
        List<AssetInfo> assetInfos = assetInfoService.findAll();
        return new ResponseEntity<List<AssetInfo>>(assetInfos, HttpStatus.OK);
    }
    // GET 조건조회 (모델명/사용자명)
    @GetMapping("/asset/search")
    public List<AssetInfo> getAssetList(
            @RequestParam(required = false) String assetTypeCode,
            @RequestParam(required = false) String assetModelName,
            @RequestParam(required = false) String userName){
        if( assetTypeCode != null ){
            return assetInfoService.findAllByAssetTypeCode(AssetInfoSpecs.withAssetTypeCode(assetTypeCode));
        } else if( assetModelName != null ){
            return assetInfoService.findAllByAssetModelName(AssetInfoSpecs.withAssetModelName(assetModelName));
        } else if ( userName != null ){
            return assetInfoService.findAllByUserName(AssetInfoSpecs.withUserName(userName));
        } else {
            return assetInfoService.findAll();
        }
    }
    // GET 페이징
    @GetMapping(value = "/asset/paging")
    public Page<AssetInfo> findAssetByPageRequest(final Pageable pageable) {
        return assetInfoService.findAssetByPageRequest(pageable);
    }

    // READ
    // GET 자산 조회
    @GetMapping(value = "/asset/{assetNo}/detail")
    public ResponseEntity<AssetInfo> getAssetInfo(@PathVariable("assetNo") String assetNo) {
        return new ResponseEntity<AssetInfo>(assetInfoService.findByAssetNo(assetNo),HttpStatus.OK);
    }

    // UPDATE (PATCH)
    @PatchMapping(value = "/asset/{assetNo}/detail/patch")
    public ResponseEntity<AssetInfo> patchAssetInfo(@PathVariable String assetNo,
                                          @RequestBody AssetInfo assetInfo) {
        AssetInfo updateAssetInfo = assetInfoService.patchAssetInfo(assetNo, assetInfo);
        if(updateAssetInfo != null){	//exist
            return new ResponseEntity<AssetInfo>(updateAssetInfo, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<AssetInfo>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    // 자산 삭제 (요구사항에 없음)
    @DeleteMapping(value = "/asset/{assetNo}/delete")
    public ResponseEntity<Void> deleteAssetInfo(@PathVariable("assetNo") String assetNo) {
        assetInfoService.deleteByAssetNo(assetNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
