package com.api.domain.services.dispatch.mapper;

import com.api.app.dto.DispatchDTO;
import com.api.domain.models.Dispatch;
import com.api.domain.models.Logistic;
import com.api.domain.models.auth.Client;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class DispatchMapper {

    @Transactional
    public Dispatch DtoToEntity(DispatchDTO dispatchDTO) {

        Dispatch dispatch = new Dispatch();

        Client user = new Client();
        user.setId(dispatchDTO.getUser_id());

        Logistic logistic = new Logistic();
        logistic.setId(dispatchDTO.getLogistic_id());

        String generateGuideNumber = this.generateTrackingNumber();

        dispatch.setGuideNumber(generateGuideNumber);
        dispatch.setClient(user);
        dispatch.setLogistic(logistic);

        return dispatch;
    }

    public String generateTrackingNumber() {

        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        // Combina la fecha actual :)
        String datePrefix = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return datePrefix + "-" + uuid;
    }
}
