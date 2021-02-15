package bno.asset.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
// @Table("AssetType")
@Getter
@Setter
public class AssetType {

    @Id
    private String no;
    @Column(unique = true, nullable = false)
    private String assetTypeCode;
    @Column(nullable = false)
    private String assetTypeName;
    @Column(columnDefinition = "date default now()")
    private LocalDateTime regDate;

    public AssetType() {

    }

    public AssetType(String assetTypeCode, String assetTypeName) {
        this.assetTypeCode = assetTypeCode;
        this.assetTypeName = assetTypeName;
    }
}
