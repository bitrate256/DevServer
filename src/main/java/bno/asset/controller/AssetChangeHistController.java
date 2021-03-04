package bno.asset.controller;

import bno.asset.core.AssetChangeHist;
import bno.asset.core.AssetInfo;
import bno.asset.service.AssetChangeHistService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AssetChangeHistController {

    @Autowired
    private AssetChangeHistService assetChangeHistService;

    // CREATE
    // 자산 변경 이력 등록
    @PostMapping("/asset/{assetNo}/assetChangeHist/create")
    public ResponseEntity<AssetChangeHist> create(@RequestBody AssetChangeHist assetChangeHist) {
        return new ResponseEntity<AssetChangeHist>(assetChangeHistService.register(assetChangeHist), HttpStatus.OK);
    }

    // LIST
    // 자산 번경 이력 조회
    @GetMapping("/asset/{assetNo}/assetChangeHist")
    public ResponseEntity<List<AssetChangeHist>> getAllAssetChangeHist() {
        List<AssetChangeHist> assetChangeHists = assetChangeHistService.retrieveAll();
        return new ResponseEntity<List<AssetChangeHist>>(assetChangeHists, HttpStatus.OK);
    }

    // 이력조회시 AssetNo 조회
    @PostMapping("/asset/assetChangeHistByAssetNo")
    public ResponseEntity<List<AssetChangeHist>> postAssetNoAssetChangeHist(@RequestBody AssetInfo assetInfo) {

        System.out.println("assetInfo ===> " + assetInfo);
        List<AssetChangeHist> assetChangeHists = assetChangeHistService.retrieveByAssetNo(assetInfo);
        return new ResponseEntity<List<AssetChangeHist>>(assetChangeHists, HttpStatus.OK);
    }
}
