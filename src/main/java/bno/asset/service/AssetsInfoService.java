package bno.asset.service;

import bno.asset.core.AssetsInfo;

import java.util.List;

public interface AssetsInfoService {

    public void register(AssetsInfo assetsInfo);

    public List<AssetsInfo> findAll();
}
