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



    public String autoIncrement() {
        //
        System.out.println("public String autoIncrement() {");
        AssetCodeFormat.seq = getSeq();

        if (seq == 0 || seq < 0) {
            seq = 1;

            System.out.println("조건 : if (seq == 0 || seq < 0) {");
            return String.format(ASSETNO_FORMAT, seq);
        }
        else if (seq > 0 && seq == getSeq())

        seq = seq++;

        System.out.println("조건 : else");
        return String.format(ASSETNO_FORMAT, seq);
    }
    public int getSeq() {
        System.out.println("public int getSeq() {");
        return seq;
    }

}
