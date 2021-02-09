package bno.asset.service;

import bno.asset.core.AssetInfo;

import java.util.List;

public interface AssetInfoService {

    public void register(AssetInfo assetInfo);

    public List<AssetInfo> findAll();
}
