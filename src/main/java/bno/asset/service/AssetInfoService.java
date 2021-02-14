package bno.asset.service;

import bno.asset.core.AssetInfo;
import bno.asset.routers.AssetApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 비즈니스 로직을 구현하는 클래스
@Service // 서비스 클래스임을 나타냄
public interface AssetInfoService {

    // CREATE
    AssetInfo save(AssetInfo assetInfo);

    // LIST
    List<AssetInfo> findAll();

    // READ
    AssetInfo findByAssetNo(int assetNo);

    // UPDATE
    void updateById(int assetNo, AssetInfo assetInfo);

    // DELETE
    void deleteByAssetNo(int assetNo);

}
