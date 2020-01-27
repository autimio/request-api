package com.test.request.service;

import com.test.request.dao.RequestDao;
import com.test.request.model.Request;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Request> findRequestById(int id) {
        return requestDao.findById(id);
    }

    @Override
    public void updateRequest(Request request) {
        requestDao.save(request);
    }
}
