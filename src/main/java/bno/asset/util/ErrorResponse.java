package bno.asset.util;

import lombok.Getter;
import lombok.Setter;

// api 요청 실패시 Response
// 요청 실패시에 errorMessage 와 errorCode 를 반환한다.
@Getter
@Setter
public class ErrorResponse extends BasicResponse {
    private String errorMessage;
    private String errorCode;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorCode = "ErrorResponse() : 404";
    }
    public ErrorResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
