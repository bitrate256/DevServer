package bno.asset.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class AssetType {

    @Id
    private String no;
    @Column(unique = true, nullable = false)
    private String assetsTypeCode;
    @Column(nullable = false)
    private String assetsTypeName;
    @Column(columnDefinition = "date default now()")
    private LocalDateTime regDate;

    public AssetType() {

    }

    public AssetType(String assetsTypeCode, String assetsTypeName) {
        this.assetsTypeCode = assetsTypeCode;
        this.assetsTypeName = assetsTypeName;
    }
}
