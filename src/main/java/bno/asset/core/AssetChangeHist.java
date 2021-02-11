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
    private AssetInfo asset_no;
    @Column(nullable = false)
    private LocalDateTime chng_date;
    private String chng_rsn;

    public AssetChangeHist() {

    }
}
