package pe.edu.uni.semana03.control;

import pe.edu.uni.semana03.dto.MateDto;
import pe.edu.uni.semana03.service.MateService;

public class MateController {

    private final MateService mateService;

    public MateController() {
        mateService = new MateService();
    }

    public MateDto procesar(MateDto bean) {
        return mateService.procesar(bean);
    }

}
