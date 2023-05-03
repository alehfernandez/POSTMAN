package com.openbootcamp.demo.controllers;

import com.openbootcamp.demo.models.BootCamper;
import com.openbootcamp.demo.service.BootCamperService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@Path("/")

public class BootcampersController {

    private final BootCamperService bootcamperService;

    public BootcampersController(BootCamperService bootcamperService) {
        this.bootcamperService = bootcamperService;

        this.bootcamperService.add(new BootCamper("uno", Math.random()));
        this.bootcamperService.add(new BootCamper("dos", Math.random()));
        this.bootcamperService.add(new BootCamper("tres", Math.random()));
        this.bootcamperService.add(new BootCamper("cuatro", Math.random()));
        this.bootcamperService.add(new BootCamper("cinco", Math.random()));
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<BootCamper> listartodo(){
        return bootcamperService.getAll();
    }

    @GET
    @Path("/bootcampers/{nombre}")
    @Produces("application/json")
    public BootCamper listarUno(@PathParam("nombre") String nombre) {
        return bootcamperService.get(nombre);
    }

    @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes("application/json")
    public Response meterBootcamper(BootCamper bootcamper) {
        bootcamperService.add(bootcamper);

        return Response.created(
                URI.create("/bootcampers/" + bootcamper.getNombre())
        ).build();

    }
}
