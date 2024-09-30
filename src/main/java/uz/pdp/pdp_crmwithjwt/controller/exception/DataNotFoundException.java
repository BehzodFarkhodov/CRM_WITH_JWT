package uz.pdp.pdp_crmwithjwt.controller.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
