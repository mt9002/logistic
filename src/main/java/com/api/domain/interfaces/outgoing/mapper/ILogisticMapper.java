package com.api.domain.interfaces.outgoing.mapper;

import com.api.domain.models.Logistic;
import com.api.app.dto.LogisticDTO;

public interface ILogisticMapper {
    Logistic createMapper(LogisticDTO logisticDTO);
    Logistic updateMapper(LogisticDTO logisticDTO, Logistic updatedLogistic);
}
