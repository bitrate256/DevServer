package bno.asset.controller;

import bno.asset.core.AssetsInfo;
import bno.asset.service.AssetsInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AssetsController {
    //
    @Autowired
    private AssetsInfoService assetsInfoService;

    @PostMapping("/")
    public String home() {
        return "";
    }

    @PostMapping("/Create")
    public String createAssetsInfo(AssetsInfo assetsInfo) {
        //
        assetsInfoService.register(assetsInfo);

        return "1";
    }
}
