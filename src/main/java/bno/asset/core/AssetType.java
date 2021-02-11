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
    private String asset_type_code;
    @Column(nullable = false)
    private String asset_type_name;
    @Column(columnDefinition = "date default now()")
    private LocalDateTime reg_date;

    public AssetType() {

    }

    public AssetType(String asset_type_code, String asset_type_name) {
        this.asset_type_code = asset_type_code;
        this.asset_type_name = asset_type_name;
    }
}
