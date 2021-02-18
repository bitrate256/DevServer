package bno.asset.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

// api 요청 성공시 Response
// 요청 성공시 반환하고자 하는 데이터를 T data 에, 이 데이터의 길이인 int count 를 반환한다.
@Getter
@Setter
public class CommonResponse<T> extends BasicResponse {
    private int count;
    private T data;

    public CommonResponse(T data) {
        this.data = data;
        if(data instanceof List) {
            this.count = ((List<?>)data).size();
        } else {
            this.count = 1;
        }
    }
}
