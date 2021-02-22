package bno.asset.service;

import bno.asset.core.AssetInfo;
import bno.asset.routers.AssetInfoApi;
import bno.asset.service.logic.AssetInfoLogic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


public interface AssetInfoService {

    // CREATE
    AssetInfo save(AssetInfo assetInfo);
    String selectSeq() throws Exception;

    // LIST
    List<AssetInfo> findAll();
    List<AssetInfo> findAllByAssetModelName(Specification<AssetInfo> withAssetModelName);
    List<AssetInfo> findAllByUserName(Specification<AssetInfo> withUserName);

    // LIST 페이징
    Page<AssetInfo> findAssetByPageRequest(Pageable pageable);
//    Page<AssetInfo> findAll(Specification<AssetInfo>spec,Pageable pageable);
//    Specification<AssetInfo> findAll(AssetInfo.toSpecification());

    // READ
    AssetInfo findByAssetNo(String assetNo);

    // UPDATE
    AssetInfo patchAssetInfo(String assetNo, AssetInfo assetInfo);

    // DELETE
    void deleteByAssetNo(String assetNo);

//    List<AssetInfo> findByAssetModelNameLikeAndUserNameLike(String assetModelName, String userName);
    // YYYY-MM-DD
}
