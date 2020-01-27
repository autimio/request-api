package com.test.request.controller;

import com.test.request.model.Request;
import com.test.request.service.RequestService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/request")
public class RequestController {

    final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

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
        return requestService.getAllRequests();
    }

    /**
     * Method to fetch Request by id.
     * @param id
     * @return
     */
    @GetMapping(value= "/getbyid/{request-id}")
    public Optional<Request> getById(@PathVariable(value= "request-id") int id) {
        return requestService.findRequestById(id);
    }

    /**
     * Method to update Request by id.
     * @param id
     * @param request
     * @return
     */
    @PutMapping(value= "/update/{request-id}")
    public String update(@PathVariable(value= "request-id") int id, @RequestBody Request request) {
        request.setCode(id);
        requestService.updateRequest(request);
        return "Request record for request-id=" + id + " updated.";
    }
}
