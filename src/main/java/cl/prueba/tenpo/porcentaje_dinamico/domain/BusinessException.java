package cl.prueba.tenpo.porcentaje_dinamico.domain;

public class BusinessException extends Exception {
    public static final int PARAM_ERROR_STRING = 400;
    public static final int RATE_LIMIT_ERROR_STRING = 429;

    private int code;

    public BusinessException(int codeParam, String message) {
        super(message);
        this.code = codeParam;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
}