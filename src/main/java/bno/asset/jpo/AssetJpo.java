package bno.asset.jpo;

// LIST 조건검색 / 페이징을 위한 DTO (엔티티 아님)
public class AssetJpo {
    private String assetTypeCode;
    private String assetModelName;
    private String userName;
    private int page;
    private int pageSize;

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "AssetJpo{" +
                "assetTypeCode='" + assetTypeCode + '\'' +
                ", assetModelName='" + assetModelName + '\'' +
                ", userName='" + userName + '\'' +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
