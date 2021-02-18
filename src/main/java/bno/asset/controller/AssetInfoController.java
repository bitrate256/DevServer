package bno.asset.controller;

import bno.asset.core.AssetInfo;
import bno.asset.service.AssetInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    private AssetInfoService assetInfoService;

    @PostMapping("/")
    public String home() {
        return "";
    }

    // CREATE
    // POST 자산 등록
    @PostMapping(value = "/create")
    public ResponseEntity<AssetInfo> create(@RequestBody AssetInfo assetInfo) {
        System.out.println("AssetInfo CREATE 값 확인      ========>    "+assetInfo.toString());
        return new ResponseEntity<AssetInfo>(assetInfoService.save(assetInfo), HttpStatus.OK);
    }

    // LIST
    // POST 자산 목록 조회
    @PostMapping(value = "/asset")
    public ResponseEntity<List<AssetInfo>> getAllasset() {
        List<AssetInfo> assetInfos = assetInfoService.findAll();
        return new ResponseEntity<List<AssetInfo>>(assetInfos, HttpStatus.OK);
    }

    // READ
    // GET 자산 조회
    @GetMapping(value = "/asset/{assetNo}")
    public ResponseEntity<AssetInfo> getAssetInfo(@PathVariable("assetNo") String assetNo) {
        return new ResponseEntity<AssetInfo>(assetInfoService.findByAssetNo(assetNo),HttpStatus.OK);
    }

    // UPDATE
    // 자산 수
    @PutMapping(value = "/asset/{assetNo}")
    public ResponseEntity<AssetInfo> updateAssetInfo(@PathVariable("assetNo") String assetNo,
                                                     @RequestBody AssetInfo assetInfo) {
        assetInfoService.updateById(assetNo, assetInfo);
        return new ResponseEntity<AssetInfo>(assetInfo, HttpStatus.OK);
    }

    // DELETE정
    @DeleteMapping(value = "/asset/{assetNo}")
    public ResponseEntity<Void> deleteAssetInfo(@PathVariable("assetNo") String assetNo) {
        assetInfoService.deleteByAssetNo(assetNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
