package bno.asset.controller;

import bno.asset.core.AssetInfo;
import bno.asset.jpo.AssetJpo;
import bno.asset.service.AssetInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public void create(@RequestBody AssetInfo assetInfo) {
        System.out.println("AssetInfo CREATE 값 확인      ========>    "+assetInfo.toString());
        assetInfoService.save(assetInfo);
//        return new ResponseEntity<AssetInfo>(assetInfoService.save(assetInfo), HttpStatus.OK);
    }

    // LIST
    // GET 자산 전체목록 조회
    @GetMapping(value = "/asset")
    public ResponseEntity<Page<AssetInfo>> getAllasset(
            @RequestParam(required = false, value = "page") int page,
            @RequestParam(required = false, value = "pageSize") int pageSize) {
        Page<AssetInfo> assetInfos = assetInfoService.findAll(PageRequest.of(page, pageSize, Sort.Direction.DESC, "assetNo"));
        return new ResponseEntity<Page<AssetInfo>>(assetInfos, HttpStatus.OK);
    }
    // POST 조건조회 (모델명/사용자명)
    @PostMapping("/asset/search")
    public Page<AssetInfo> getAssetList(
            // 코드검색 콤보박스용 컬럼
            @RequestBody(required = false) AssetJpo assetType){
        return assetInfoService.findAllJpo(assetType, PageRequest.of(assetType.getPage(), assetType.getPageSize(), Sort.Direction.DESC, "assetNo"));
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
        if(updateAssetInfo != null){
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
