package bno.asset.core;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "AssetInfo")
@Data
// @AllArgsConstructor
// @NoArgsConstructor
public class AssetInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    private String assetNo;
    @OneToOne
    @JoinColumn(name = "assetTypeCode", nullable = false)
    private AssetType assetTypeCode;
    @Column(nullable = false)
    private String userName;
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

    public AssetInfo(Long id, String assetNo, AssetType assetTypeCode, String userName, String assetModelName,
                     String assetSerialNo, LocalDateTime useStartDate, String assetStat,
                     String assetPjtLoc, String etc) {
        this.assetNo = assetNo;
        this.assetTypeCode = assetTypeCode;
        this.userName = userName;
        this.assetModelName = assetModelName;
        this.assetSerialNo = assetSerialNo;
        this.useStartDate = useStartDate;
        this.assetStat = assetStat;
        this.assetPjtLoc = assetPjtLoc;
        this.etc = etc;
    }

}
