package bno.asset.service;

import bno.asset.core.AssetChangeHist;


import java.util.List;


public interface AssetChangeHistService {

    // CREATE
    AssetChangeHist register(AssetChangeHist assetChangeHist);

    List<AssetChangeHist> retrieveAll();

}
