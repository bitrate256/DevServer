package bno.asset.jpo;

public class AssetJpo {
    private String assetTypeCode;
    private String assetModelName;
    private String userName;

    public AssetJpo() {

    }

    public String getAssetTypeCode() {
        return assetTypeCode;
    }

    public void setAssetTypeCode(String assetTypeCode) {
        this.assetTypeCode = assetTypeCode;
    }

    public String getAssetModelName() {
        return assetModelName;
    }

    public void setAssetModelName(String assetModelName) {
        this.assetModelName = assetModelName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "AssetJpo{" +
                "assetTypeCode='" + assetTypeCode + '\'' +
                ", assetModelName='" + assetModelName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
