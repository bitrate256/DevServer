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
    private String asset_no;
    @OneToOne
    @JoinColumn(name = "asset_type_code", nullable = false)
    private AssetType asset_type_code;
    @Column(nullable = false)
    private String user_name;
    @Column(nullable = false)
    private String asset_model_name;
    @Column(unique = true, nullable = false)
    private String asset_serial_no;
    @Column(nullable = false)
    private LocalDateTime use_start_date;
    @Column(nullable = false)
    private String asset_stat;
    @Column(nullable = false)
    private String asset_pjt_loc;
    @Column(nullable = false)
    private String etc;
    @Column(columnDefinition = "date default now()")
    private LocalDateTime reg_date;

    public AssetInfo() {

    }

    public AssetInfo(AssetType asset_type_code, String user_name, String asset_model_name,
                     String asset_serial_no, LocalDateTime use_start_date, String asset_stat,
                     String asset_pjt_loc, String etc) {
        this.asset_type_code = asset_type_code;
        this.user_name = user_name;
        this.asset_model_name = asset_model_name;
        this.asset_serial_no = asset_serial_no;
        this.use_start_date = use_start_date;
        this.asset_stat = asset_stat;
        this.asset_pjt_loc = asset_pjt_loc;
        this.etc = etc;
    }
}
