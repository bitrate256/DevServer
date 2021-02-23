package bno.asset.service;

import bno.asset.core.AssetChangeHist;


import java.util.List;


public interface AssetChangeHistService {

    // CREATE
    AssetChangeHist register(AssetChangeHist assetChangeHist);

    // 이력 전체 리스트
    List<AssetChangeHist> retrieveAll();

}
