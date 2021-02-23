package bno.asset.controller;

import bno.asset.core.AssetType;
import bno.asset.service.AssetTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AssetTypeController {

    @Autowired
    private AssetTypeService assetTypeService;

    // CREATE
    // 자산 유형 등록
    @PostMapping("/assetType/create")
    public AssetType createAssetType(@RequestBody AssetType assetType) {
        //
        assetTypeService.register(assetType);
        return assetTypeService.findByAssetTypeCode(assetType.getAssetTypeCode());
    }

    // LIST
    // GET 자산 유형 조회
    @GetMapping("/assetType/list")
    public ResponseEntity<List<AssetType>> getAllAssetType() {
        List<AssetType> assetTypeList = assetTypeService.findAll();
        return new ResponseEntity<List<AssetType>>(assetTypeList, HttpStatus.OK);
    }

    // READ 코드 읽어오기
    @GetMapping("/assetType/{assetTypeCode}")
    public ResponseEntity<AssetType> getAssetType(@PathVariable("assetTypeCode") String assetTypeCode) {
        return new ResponseEntity<AssetType>(assetTypeService.findByAssetTypeCode(assetTypeCode), HttpStatus.OK);
    }
}
