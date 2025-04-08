package pe.edu.uni.problema08.controller;

import pe.edu.uni.problema08.dto.MateDto;
import pe.edu.uni.problema08.service.MateService;

public class MateController {
    
    private MateService mateService;

    public MateController() {
        mateService = new MateService();
    }
    
    public MateDto procesar(MateDto bean){
        return mateService.procesar(bean);
    }  
    
}
