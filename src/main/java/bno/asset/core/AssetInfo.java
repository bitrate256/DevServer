package bno.asset.core;

import bno.asset.util.DateFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "AssetInfo")
@Data
public class AssetInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    private String assetNo;
    // 피드백 수정 백업
    @ManyToOne
    @JoinColumn(name = "assetTypeCode", nullable = false)
    private AssetType assetType;
    @ApiModelProperty(value = "userName")
    @Column(nullable = false)
    private String userName;
    @ApiModelProperty(value = "assetModelName")
    @Column(nullable = false)
    private String assetModelName;
    @Column(unique = true, nullable = false)
    private String assetSerialNo;
    @Column(nullable = false)
    private String useStartDate;
    @Column(nullable = false)
    private String assetStat;
    @Column(nullable = false)
    private String assetPjtLoc;
    @Column(nullable = false)
    private String etc;
    @Column(columnDefinition = "date default now()")
    private String regDate;

    public AssetInfo() {

    }

    public AssetInfo(String assetNo,
                     AssetType assetType,
                     String userName, String assetModelName,
                     String assetSerialNo, String assetStat,
                     String assetPjtLoc, String etc) {
        this.assetNo = assetNo;
        this.assetType = assetType;
        this.userName = userName;
        this.assetModelName = assetModelName;
        this.assetSerialNo = assetSerialNo;
        this.useStartDate = DateFormat.today();
        this.assetStat = assetStat;
        this.assetPjtLoc = assetPjtLoc;
        this.etc = etc;
        this.regDate = DateFormat.today();
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
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

    public String getUseStartDate() {
        return useStartDate;
    }

    public void setUseStartDate(String useStartDate) {
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
