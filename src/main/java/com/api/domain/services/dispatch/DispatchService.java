package com.api.domain.services.dispatch;

import com.api.app.dto.DispatchDTO;
import com.api.app.dto.Response;
import com.api.domain.interfaces.incoming.IDispatchService;
import com.api.domain.interfaces.outgoing.dispatch.IDispatchRepository;
import com.api.domain.models.Dispatch;
import com.api.domain.services.dispatch.mapper.DispatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispatchService implements IDispatchService {

    private final IDispatchRepository iDispatchRepository;
    private final DispatchMapper dispatchMapper;

    @Autowired
    public DispatchService(IDispatchRepository iDispatchRepository, DispatchMapper dispatchMapper) {
        this.iDispatchRepository = iDispatchRepository;
        this.dispatchMapper = dispatchMapper;
    }

    @Override
    public Response createDispatch(DispatchDTO dto) {
        Dispatch dispatch = dispatchMapper.DtoToEntity(dto);
        var response = iDispatchRepository.createDispatch(dispatch);
        return response;
    }

    @Override
    public Response getByIdDispatch(Long id) {
        var response = iDispatchRepository.getByIdDispatch(id);
        return response;
    }

    @Override
    public Response updateDispatch(Long id, DispatchDTO dto) {
        var response = iDispatchRepository.updateDispatch(id, dto);
        return response;
    }

    @Override
    public Response deleteDispatch(Long id) {
        var response = iDispatchRepository.deleteDispatch(id);
        return response;
    }
}
