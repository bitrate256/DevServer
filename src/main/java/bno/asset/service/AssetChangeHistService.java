package bno.asset.service;

import bno.asset.core.AssetChangeHist;
import bno.asset.core.AssetInfo;


import java.util.List;


public interface AssetChangeHistService {

    // CREATE
    AssetChangeHist register(AssetChangeHist assetChangeHist);

    // 이력 전체 리스트
    List<AssetChangeHist> retrieveAll();

    // 이력조회시 AssetNo 조회
    List<AssetChangeHist> retrieveByAssetNo(AssetInfo assetInfo);

}
