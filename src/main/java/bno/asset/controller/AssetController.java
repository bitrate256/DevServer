package bno.asset.controller;

import bno.asset.core.AssetInfo;
import bno.asset.routers.AssetApi;
import bno.asset.service.AssetInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
// Controller 클래스
// 클라이언트로 부터 요청을 받아 해당 처리를 한 후 요청의 응답을 클라이언트에 보냄.
public class AssetController {
    //
    @Autowired
    private AssetInfoService assetInfoService;

    @PostMapping("/")
    public String home() {
        return "";
    }

    // CREATE
    @PostMapping
    public ResponseEntity<AssetInfo> save(@RequestBody AssetInfo assetInfo) {
        return new ResponseEntity<AssetInfo>(assetInfoService.save(assetInfo), HttpStatus.OK);
    }

    // LIST
    @PostMapping(value = "/asset")
    public ResponseEntity<List<AssetInfo>> getAllasset() {
        List<AssetInfo> assetInfos = assetInfoService.findAll();
        return new ResponseEntity<List<AssetInfo>>(assetInfos, HttpStatus.OK);
    }
    // LIST 2안 (service 없음)
    @GetMapping("/asset")
    public List<AssetInfo> listAllAsset() {
        List<AssetInfo> list = new ArrayList<>();
        Iterable<AssetInfo> iterable = assetInfoService.findAll();
        for (AssetInfo assetInfo : iterable) {
            list.add(assetInfo);
        }
        return list;
    }

    // READ 1안 (AssetApi 에서 Optional<findById> 사용)
    @GetMapping(value = "/asset/{assetNo}")
    public ResponseEntity<AssetInfo> getAssetInfo(@PathVariable("assetNo") int assetNo) {
        return new ResponseEntity<AssetInfo>(assetInfoService.findByAssetNo(assetNo),HttpStatus.OK);
    }
    // READ 2안
    // 인수인계 로직을 따른 controller 는?

    // UPDATE
    @PutMapping(value = "/asset/{assetNo}")
    public ResponseEntity<AssetInfo> updateAssetInfo(@PathVariable("assetNo") int assetNo,
                                                     @RequestBody AssetInfo assetInfo) {
        assetInfoService.updateById(assetNo, assetInfo);
        return new ResponseEntity<AssetInfo>(assetInfo, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping(value = "/asset/{assetNo}")
    public ResponseEntity<Void> deleteAssetInfo(@PathVariable("assetNo") int assetNo) {
        assetInfoService.deleteByAssetNo(assetNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
