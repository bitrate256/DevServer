package bno.asset.controller;

import bno.asset.core.AssetChangeHist;
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
    @PostMapping()
    public ResponseEntity<AssetChangeHist> create(@RequestBody AssetChangeHist assetChangeHist) {
        return new ResponseEntity<AssetChangeHist>(assetChangeHistService.register(assetChangeHist), HttpStatus.OK);
    }

    // LIST
    @GetMapping
    public ResponseEntity<List<AssetChangeHist>> getAllAssetChangeHist() {
        List<AssetChangeHist> assetChangeHists = assetChangeHistService.retrieveAll();
        return new ResponseEntity<List<AssetChangeHist>>(assetChangeHists, HttpStatus.OK);
    }

}
