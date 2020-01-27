package com.test.request.controller;

import com.test.request.model.Request;
import com.test.request.service.RequestService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

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

    @GetMapping(value="/getall")
    public Collection<Request> getAll() {
        return requestService.getAllRequests();
    }
}
