package bno.asset.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Asset")
public class AssetInfo {

    @Id
    private String assetNo;
    @OneToOne
    @JoinColumn(name = "asset_type_code", nullable = false)
    private AssetType assetTypeCode;
    @Column(nullable = false)
    private String user_name;
    @Column(nullable = false)
    private String assetModelName;
    @Column(unique = true, nullable = false)
    private String assetSerialNo;
    @Column(nullable = false)
    private LocalDateTime useStartDate;
    @Column(nullable = false)
    private String assetStat;
    @Column(nullable = false)
    private String assetPjtLoc;
    @Column(nullable = false)
    private String etc;
    @Column(columnDefinition = "date default now()")
    private LocalDateTime regDate;

    public AssetInfo() {

    }

    public AssetInfo(AssetType assetTypeCode, String user_name, String assetModelName, String assetSerialNo, LocalDateTime useStartDate, String assetStat, String assetPjtLoc, String etc) {
        this.assetTypeCode = assetTypeCode;
        this.user_name = user_name;
        this.assetModelName = assetModelName;
        this.assetSerialNo = assetSerialNo;
        this.useStartDate = useStartDate;
        this.assetStat = assetStat;
        this.assetPjtLoc = assetPjtLoc;
        this.etc = etc;
    }
}
