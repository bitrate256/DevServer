package bno.asset.controller;

import bno.asset.core.AssetInfo;
import bno.asset.service.AssetInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AssetsController {
    //
    @Autowired
    private AssetInfoService assetInfoService;

    @PostMapping("/")
    public String home() {
        return "";
    }

    @PostMapping("/Create")
    public String createAssetsInfo(AssetInfo assetInfo) {
        //
        assetInfoService.register(assetInfo);

        return "1";
    }
}
