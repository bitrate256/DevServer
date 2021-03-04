package bno.asset.core;

import bno.asset.util.DateFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class AssetType {

    @Id
    @Column(name = "assetTypeCode")
    private String assetTypeCode;
    @Column(nullable = false)
    private String assetTypeName;
    @Column
    private String regDate;

    public AssetType() {

    }

    public AssetType(String assetTypeCode, String assetTypeName) {
        this.assetTypeCode = assetTypeCode;
        this.assetTypeName = assetTypeName;
        this.regDate = DateFormat.today();
    }
}
