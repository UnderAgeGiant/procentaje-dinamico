package cl.prueba.tenpo.porcentaje_dinamico.domain;

public class PorcentajeDinamicoResponseBody {
    private int code;
    private String message;
    private PorcentajeDinamicoData data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PorcentajeDinamicoData getData() {
        return data;
    }

    public void setData(PorcentajeDinamicoData data) {
        this.data = data;
    }
}


