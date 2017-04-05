package com.github.jmccloskey.api.impl;


import com.github.jmccloskey.api.NotFoundException;
import com.github.jmccloskey.api.StatusApiService;
import com.github.jmccloskey.model.Status;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public class StatusApiServiceImpl extends StatusApiService {
    @Override
    public Response status(SecurityContext securityContext) throws NotFoundException {
        return Response.ok().entity(new Status().status(Status.StatusEnum.OK)).build();
    }
}
