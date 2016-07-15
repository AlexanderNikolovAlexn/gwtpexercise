package com.samodeika.shared.service;

import com.samodeika.shared.model.Hello;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/api/hellos")
public interface HelloServiceAsync extends RestService {

    @GET
    public void getHellos( MethodCallback<List<Hello>> callback);

    @GET
    @Path("/{id}")
    public void getHellos(@PathParam("id") String id, MethodCallback<List<Hello>> callback);
}