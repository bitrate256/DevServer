package bno.asset.core;

import bno.asset.util.DateFormat;
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
    @JoinColumn(name = "assetNo", nullable = false)
    private AssetInfo assetNo;
    @Column(nullable = false)
    private String chngDate;
    private String chngRsn;

    public AssetChangeHist() {
        this.chngDate = DateFormat.today();
        this.chngRsn = DateFormat.today();
    }
}
