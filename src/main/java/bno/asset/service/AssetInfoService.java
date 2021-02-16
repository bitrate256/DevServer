package bno.asset.service;

import bno.asset.core.AssetInfo;
import org.springframework.stereotype.Service;

import java.util.List;

// 비즈니스 로직을 구현하는 클래스
@Service // 서비스 클래스임을 나타냄
public interface AssetInfoService {

    // CREATE
    AssetInfo save(AssetInfo assetInfo);

    // LIST
    List<AssetInfo> findAll();

    // READ
    AssetInfo findByAssetNo(String assetNo);

    // UPDATE
    void updateById(String assetNo, AssetInfo assetInfo);

    // DELETE
    void deleteByAssetNo(String assetNo);

}
