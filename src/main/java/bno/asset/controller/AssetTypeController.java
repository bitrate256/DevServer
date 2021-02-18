package bno.asset.controller;

import bno.asset.core.AssetType;
import bno.asset.service.AssetTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AssetTypeController {

    @Autowired
    private AssetTypeService assetTypeService;

    // CREATE
    // 자산 유형 등록
    @PostMapping("/createAssetType/create")
    public AssetType createAssetType(@RequestBody AssetType assetType) {
        //
        assetTypeService.register(assetType);
        return assetTypeService.findByAssetTypeCode(assetType.getNo());
    }

    // LIST
    // GET 자산 유형 조회
    @GetMapping("/createAssetType/list")
    public ResponseEntity<List<AssetType>> getAllAssetType() {
        List<AssetType> assetTypeList = assetTypeService.findAll();
        return new ResponseEntity<List<AssetType>>(assetTypeList, HttpStatus.OK);
    }
}
