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
    private AssetType assetTypeCodeData;
    @Column(nullable = false)
    private String assetTypeCode;
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

    public AssetInfo(String assetNo,
                     AssetType assetTypeCodeData,
                     String assetTypeCode,
                     String userName, String assetModelName,
                     String assetSerialNo, LocalDateTime useStartDate, String assetStat,
                     String assetPjtLoc, String etc) {
        this.assetNo = assetNo;
        this.assetTypeCodeData = assetTypeCodeData;
        this.assetTypeCode = assetTypeCode;
        this.userName = userName;
        this.assetModelName = assetModelName;
        this.assetSerialNo = assetSerialNo;
        this.useStartDate = useStartDate;
        this.assetStat = assetStat;
        this.assetPjtLoc = assetPjtLoc;
        this.etc = etc;
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public AssetType getAssetTypeCodeData() {
        return assetTypeCodeData;
    }

//    public void setAssetTypeCodeData(AssetType assetTypeCodeData) {
//        this.assetTypeCodeData = assetTypeCodeData;
//    }

    public String getAssetTypeCode() {
        return assetTypeCode;
    }

    public void setAssetTypeCode(String assetTypeCode) {
        this.assetTypeCode = assetTypeCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAssetModelName() {
        return assetModelName;
    }

    public void setAssetModelName(String assetModelName) {
        this.assetModelName = assetModelName;
    }

    public String getAssetSerialNo() {
        return assetSerialNo;
    }

    public void setAssetSerialNo(String assetSerialNo) {
        this.assetSerialNo = assetSerialNo;
    }

    public LocalDateTime getUseStartDate() {
        return useStartDate;
    }

    public void setUseStartDate(LocalDateTime useStartDate) {
        this.useStartDate = useStartDate;
    }

    public String getAssetStat() {
        return assetStat;
    }

    public void setAssetStat(String assetStat) {
        this.assetStat = assetStat;
    }

    public String getAssetPjtLoc() {
        return assetPjtLoc;
    }

    public void setAssetPjtLoc(String assetPjtLoc) {
        this.assetPjtLoc = assetPjtLoc;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
