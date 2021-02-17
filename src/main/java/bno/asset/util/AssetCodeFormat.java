package bno.asset.util;

import bno.asset.core.AssetType;

// 일련번호 생성 로직
public class AssetCodeFormat {
    //
    private static int seq = 0;
    private static final String firstName = "BNO_";
    private AssetType assetTypeCode;

    private static final String ASSETNO_FORMAT = "%04d";

    public AssetCodeFormat(){
        //


    }

    // 시퀀스 번호 생성 메소드
    public String autoIncrement() {

        System.out.println("public String autoIncrement() {");
        AssetCodeFormat.seq = getSeq();

        // 기존 시퀀스 없을 때
        if (seq == 0 || seq < 0) {
            seq = 1;

            System.out.println("조건 : if (seq == 0 || seq < 0) {");
            return String.format(ASSETNO_FORMAT, seq);
        }
        // 기존 시퀀스 있을 때
        else if (seq > 0 && seq == getSeq())

        seq = seq++;

        System.out.println("조건 : else");
        return String.format(ASSETNO_FORMAT, seq);
    }

    // 기존 시퀀스 번호 감지
    public int getSeq() {
        System.out.println("public int getSeq() {");
        return seq;
    }

}
