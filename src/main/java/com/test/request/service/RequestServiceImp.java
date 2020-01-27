package com.test.request.service;

import com.test.request.dao.RequestDao;
import com.test.request.model.Request;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class RequestServiceImp implements RequestService {

    final RequestDao requestDao;

    public RequestServiceImp(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    @Override
    public void createRequest(List<Request> requests) {
        requestDao.saveAll(requests);
    }

    @Override
    public Collection<Request> getAllRequests() {
        return requestDao.findAll();
    }
}
