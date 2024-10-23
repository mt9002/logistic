package com.api.domain.services.logistic;

import com.api.app.dto.LogisticDTO;
import com.api.app.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.domain.interfaces.outgoing.logistic.ILogisticRepository;
import com.api.domain.interfaces.incoming.ILogisticService;
import com.api.domain.models.Logistic;
import com.api.domain.services.logistic.calculator.DiscountCalculator;
import com.api.domain.services.logistic.mapper.LogisticMapper;

@Service
public class LogisticService implements ILogisticService {

    private final ILogisticRepository iLogisticRepository;
    private final DiscountCalculator discountCalculator;

    @Autowired
    public LogisticService(ILogisticRepository landRepository) {
        this.iLogisticRepository = landRepository;
        this.discountCalculator = new DiscountCalculator();

    }

    @Override
    public Response createLogistic(LogisticDTO dto) {

        if (dto.getTypeDelivery().equals("LAND")) {
            discountCalculator.landDiscount(dto);
        }
        
        if (dto.getTypeDelivery().equals("SEA")) {
            discountCalculator.seaDiscount(dto);
        }

        LogisticMapper logisticMapper = new LogisticMapper();
        Logistic logisticEntity = logisticMapper.createMapper(dto);

        Response response = iLogisticRepository.createLogistic(logisticEntity);
        return response;
    }

    @Override
    public Response getByIdLogistic(Long id) {
        var response = iLogisticRepository.getByIdLogistic(id);
        return response;
    }

    @Override
    public Response updateLogistic(Long id, LogisticDTO dto) {
        var response = iLogisticRepository.updateLogistic(id, dto);
        return response;
    }

    @Override
    public Response deleteLogistic(Long id) {
        var response = iLogisticRepository.deleteLogistic(id);
        return response;
    }
}
