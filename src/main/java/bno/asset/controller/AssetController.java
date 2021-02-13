package bno.asset.controller;

import bno.asset.core.AssetInfo;
import bno.asset.service.AssetInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@AllArgsConstructor
// Controller 클래스
// 클라이언트로 부터 요청을 받아 해당 처리를 한 후 요청의 응답을 클라이언트에 보냄.
public class AssetController {
    //
    @Autowired
    private AssetInfoService assetInfoService;

    @PostMapping("/")
    public String home() {
        return "";
    }

    // LIST
    @GetMapping("/asset")
    public String ModelAndView assetList() {
        List<AssetInfo> list = assetInfoService.findAll()(); // 서비스에서 요청에 해당하는 처리를 함.
        ModelAndView nextView = new ModelAndView("asset/list"); // ModelAndView 객체를 응답페이지의 위치를 지정해 생성함.
        nextView.addObject("assetList", list); // 서비스에서 받아온 데이터 List를 ModelAndView 객체에 넣음.
        return nextView; // ModelAndView 객체를 리턴함
    }

    // CREATE
    @PostMapping("/Create") // 클라이언트 요청 url 이 Create 이며 Post 방식일 때 이 메소드에서 요청
    public String createAssetInfo(AssetInfo assetInfo) {
        //
        assetInfoService.register(assetInfo);

        return "AssetsController";
    }

    // READ

    // UPDATE

    // DELETE
}
