package cl.prueba.tenpo.porcentaje_dinamico.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.prueba.tenpo.porcentaje_dinamico.domain.BusinessException;
import cl.prueba.tenpo.porcentaje_dinamico.domain.PorcentajeDinamicoData;
import cl.prueba.tenpo.porcentaje_dinamico.domain.PorcentajeDinamicoRequestBody;
import cl.prueba.tenpo.porcentaje_dinamico.domain.PorcentajeDinamicoResponseBody;

public class ProcentajeDinamicoService {
    private static final Logger logger = LoggerFactory.getLogger(ProcentajeDinamicoService.class);
    
    public PorcentajeDinamicoResponseBody resolvePorcentajeDinamico(PorcentajeDinamicoRequestBody body){
        try {
            // VALIDATE INPUT
            if (body.getNum1() == null || body.getNum2() == null) throw new BusinessException(BusinessException.PARAM_ERROR_STRING, "Input values error");
            if (body.getNum1() < 0 || body.getNum2() < 0 ) throw new BusinessException(BusinessException.PARAM_ERROR_STRING, "Input values error");

            // RESOLVE
            PorcentajeDinamicoData data = new PorcentajeDinamicoData();
            data.setValue(this.calculatePorcentajeDinamico(body));

            // RESPONSE
            return this.createResponse(data, 200, "OK");
        } catch (Exception e) {
            return this.handleException(e);
        }

    }

    public Double calculatePorcentajeDinamico(PorcentajeDinamicoRequestBody body){
        CallExternalService callService = new CallExternalService();
        Integer percent = callService.getPercentage();
        Integer sum = body.getNum1() + body.getNum2();
        Double result = sum * (1 + percent / 100.0);
        return result;
    }

    public PorcentajeDinamicoResponseBody createResponse(PorcentajeDinamicoData data, int code, String message) {
        PorcentajeDinamicoResponseBody response = new PorcentajeDinamicoResponseBody();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public PorcentajeDinamicoResponseBody handleException(Exception e) {
        if(e instanceof BusinessException){
            BusinessException be = (BusinessException) e;
            return this.createResponse(null, be.getCode(), be.getMessage());
        }
        logger.error(e.getMessage(), e);
        return this.createResponse(null, 500, "NOK");
    }
}
