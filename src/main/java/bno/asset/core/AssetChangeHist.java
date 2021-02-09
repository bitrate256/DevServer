package bno.asset.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class AssetChangeHist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq;
    @OneToOne
    @JoinColumn(name = "asset_no", nullable = false)
    private AssetInfo assetNo;
    @Column(nullable = false)
    private LocalDateTime chngDate;
    private String chngRsn;

    public AssetChangeHist() {

    }
}
