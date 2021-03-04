package bno.asset.core;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

// 모든 Entity 의 상위 클래스
// Entity 들의 createDate, modifiedDate를 자동으로 관리한다.
public class BaseTimeEntity {
    // @CreatedDate: Entity가 생성되어 저장될 때 시간이 자동 저장된다.
    @CreatedDate
    private LocalDateTime createDate;
    // @LastModifiedDate: 조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }
}
