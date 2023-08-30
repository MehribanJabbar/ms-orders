package az.ingress.msorders.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }

}
