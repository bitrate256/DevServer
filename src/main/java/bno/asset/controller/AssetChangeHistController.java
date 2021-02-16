package bno.asset.controller;

import bno.asset.core.AssetChangeHist;
import bno.asset.core.AssetInfo;
import bno.asset.routers.AssetChangeHistApi;
import bno.asset.service.AssetChangeHistService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AssetChangeHistController {

    @Autowired
    private AssetChangeHistService assetChangeHistService;

    // CREATE
    @PostMapping()
    public ResponseEntity<AssetChangeHist> save(@RequestBody AssetChangeHist assetChangeHist) {
        return new ResponseEntity<AssetChangeHist>(assetChangeHistService.save(assetChangeHist), HttpStatus.OK);
    }

    // LIST
}
