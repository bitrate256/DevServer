package bno.asset.service;

import bno.asset.core.AssetInfo;
import bno.asset.routers.AssetApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 비즈니스 로직을 구현하는 클래스
@Service // 서비스 클래스임을 나타냄
public interface AssetInfoService {

    @Autowired // 스프링부트가 자동으로 객체를 주입함.
    AssetApi assetApi;

    public List<AssetInfo> findAll() {
        List<AssetInfo> list = assetApi.findAll(); // findAll() 메소드로 테이블의 레코드 리스트를 가져옴
        return list;
    }

    public void register(AssetInfo assetInfo);
}
