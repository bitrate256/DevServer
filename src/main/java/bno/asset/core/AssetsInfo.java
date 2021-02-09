package bno.asset.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Assets")
public class AssetsInfo {

    @Id
    private String assetsNo;
    @OneToOne
    @JoinColumn(name = "asset_type_code", nullable = false)
    private AssetType assetsTypeCode;
    @Column(nullable = false)
    private String user_name;
    @Column(nullable = false)
    private String assetsModelName;
    @Column(unique = true, nullable = false)
    private String assetsSerialNo;
    @Column(nullable = false)
    private LocalDateTime useStartDate;
    @Column(nullable = false)
    private String assetsStat;
    @Column(nullable = false)
    private String assetPjtLoc;
    @Column(nullable = false)
    private String etc;
    @Column(columnDefinition = "date default now()")
    private LocalDateTime regDate;

    public AssetsInfo() {

    }

    public AssetsInfo(AssetType assetsTypeCode, String user_name, String assetsModelName, String assetsSerialNo, LocalDateTime useStartDate, String assetsStat, String assetPjtLoc, String etc) {
        this.assetsTypeCode = assetsTypeCode;
        this.user_name = user_name;
        this.assetsModelName = assetsModelName;
        this.assetsSerialNo = assetsSerialNo;
        this.useStartDate = useStartDate;
        this.assetsStat = assetsStat;
        this.assetPjtLoc = assetPjtLoc;
        this.etc = etc;
    }
}
