package com.test.request.service;

import com.test.request.model.Request;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

    /**
     * Method to fetch Request by id using mongo-db repository.
     * @param id
     * @return
     */
    Optional<Request> findRequestById(int id);

    /**
     * Method to update Request by id using mongo-db repository.
     * @param request
     */
    void updateRequest(Request request);
}
