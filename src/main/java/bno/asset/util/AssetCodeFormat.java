package bno.asset.util;

import bno.asset.core.AssetType;

// 일련번호 생성 로직
public class AssetCodeFormat {
    //
    private static int seq = 0;

    public AssetCodeFormat(){
        //
    }

    public int autoSeqence(int autoSeq) {
        //
        autoSeq = 0;
        if (AssetCodeFormat.seq == 0) {
            AssetCodeFormat.seq = 1;
        } else {
            AssetCodeFormat.seq ++;
        }

        autoSeq = AssetCodeFormat.seq;

        return autoSeq;
    }


    public static int getSeq() {
        return seq;
    }
}
