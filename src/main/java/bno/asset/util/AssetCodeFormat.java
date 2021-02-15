package bno.asset.util;

import bno.asset.core.AssetType;

// 일련번호 생성 로직
public class AssetCodeFormat {
    //
    private static final int seq = 0;
    private static final String firstName = "BNO_";
    private AssetType assetTypeCode;

    private static final String ASSETNO_FORMAT = "%04d";

    public AssetCodeFormat(){
        //


    }

    public String toAssetCodeFormat(int seq, String firstName, AssetType assetTypeCode) {
        //
        seq = Integer.parseInt(autoIncrement(getSeq()));
        firstName = "BNO_";
        assetTypeCode = this.assetTypeCode;

        return firstName + seq + "_" + assetTypeCode;
    }


    public String autoIncrement(int seq) {
        //
        seq = getSeq();

        if (seq == 0) {
            seq = 1;

            return String.format(ASSETNO_FORMAT, seq);
        }

        seq = seq++;

        return String.format(ASSETNO_FORMAT, seq);
    }


    public int getSeq() {
        return seq;
    }


    public String getFirstName() {
        return firstName;
    }


    public AssetType getAssetTypeCode() {
        return assetTypeCode;
    }

    public void setAssetTypeCode(AssetType assetTypeCode) {
        this.assetTypeCode = assetTypeCode;
    }
}
