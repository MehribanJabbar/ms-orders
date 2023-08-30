package az.ingress.msorders.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {

    UNEXPECTED_ERROR("UNEXPECTED_ERROR", "Unexpected error occurred"),
    ORDER_NOT_FOUND("ORDER_NOT_FOUND", "Order Not Found");

    private final String code;
    private final String message;
}
