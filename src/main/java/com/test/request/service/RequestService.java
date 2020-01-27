package com.test.request.service;

import com.test.request.model.Request;

import java.util.Collection;
import java.util.List;

public interface RequestService {

    /**
     * Method to create new Request in the db using mongo-db repository.
     * @param requests
     */
    void createRequest(List<Request> requests);

    /**
     * Method to fetch all Requests from the db using mongo-db repository.
     * @return Collection
     */
    Collection<Request> getAllRequests();
}
