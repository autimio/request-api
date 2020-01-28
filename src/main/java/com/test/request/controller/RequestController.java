package com.test.request.controller;

import com.test.request.model.Request;
import com.test.request.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/request")
public class RequestController {

    @Autowired
    RequestService requestService;

    /**
     * Method to save Requests in the db.
     * @param requests
     * @return
     */
    @PostMapping(value="/create")
    public String create(@RequestBody List<Request> requests) {
        requestService.createRequest(requests);
        return "Request records created.";
    }

    /**
     * Method to fetch all Requests from the db.
     * @return
     */
    @GetMapping(value="/getall")
    public Collection<Request> getAll() {
        Collection<Request> requests = requestService.getAllRequests();

        if (!requests.isEmpty()) {
            return requests;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "There are no requests in the database."
            );
        }
    }

    /**
     * Method to fetch Request by id.
     * @param id
     * @return
     */
    @GetMapping(value= "/getbyid/{request-id}")
    public Optional<Request> getById(@PathVariable(value= "request-id") int id)  {
        Optional<Request> request = requestService.findRequestById(id);

        if (!request.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "The Request with the given ID [" + id + "] was not found!"
            );
        }

        return request;
    }

    /**
     * Method to update Request by id.
     * @param id
     * @param requestBody
     * @return
     */
    @PutMapping(value= "/update/{request-id}")
    public String update(@PathVariable(value= "request-id") int id, @RequestBody Request requestBody) {
        Optional<Request> request = requestService.findRequestById(id);

        if (request.isPresent()) {
            requestBody.setCode(id);
            requestService.updateRequest(requestBody);
            return "Request record for request-id=" + id + " updated.";
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "The request with the given ID [" + id + "] was not found, so it will not be possible to make the change!"
            );
        }
    }

    /**
     * Method to delete Request by id.
     * @param id
     * @return
     */
    @DeleteMapping(value= "/delete/{request-id}")
    public String delete(@PathVariable(value= "request-id") int id) {
        Optional<Request> request = requestService.findRequestById(id);

        if (request.isPresent()) {
            requestService.deleteRequestById(id);
            return "Request record for resquest-id=" + id + " deleted.";
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "The request with the given ID [" + id + "] was not found, so it will not be possible to delete!"
            );
        }
    }

    /**
     * Method to delete all Requests from the db.
     * @return
     */
    @DeleteMapping(value= "/deleteall")
    public String deleteAll() {
        requestService.deleteAllRequests();
        return "All Requests records deleted.";
    }
}
