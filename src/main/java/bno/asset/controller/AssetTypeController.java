package bno.asset.controller;

import bno.asset.core.AssetType;
import bno.asset.service.AssetTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AssetTypeController {
    //
    @Autowired
    private AssetTypeService assetTypeService;

    @PostMapping("/createAssetType")
    public AssetType createAssetType(@RequestBody AssetType assetType) {
        //
        assetTypeService.register(assetType);

        return assetTypeService.findByAssetTypeCode(assetType.getNo());
    }
}
