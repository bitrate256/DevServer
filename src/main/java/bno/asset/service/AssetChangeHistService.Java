package bno.asset.service;

import bno.asset.core.AssetChangeHist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssetChangeHistService {

    // CREATE
    AssetChangeHist save(AssetChangeHist assetChangeHist);

    // LIST
    List<AssetChangeHist> findAll();

    // UPDATE

    // DELETE

}
