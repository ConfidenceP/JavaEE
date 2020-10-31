package me.confidence.rest;

import me.confidence.entity.Person;
import me.confidence.service.PersonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonRest {

    @Inject
    PersonService personService;

    @Path("new")
    @POST
    public Response addPerson(Person person) {
        personService.addPerson(person);
        return Response.ok(person).build();
    }

    @Path("update")
    @POST
    public Response updatePerson(Person person) {
        personService.updatePerson(person);
        return Response.ok(person).build();
    }

    @Path("{id}")
    @GET
    public Person getPerson(@PathParam("id") Long id) {
        return personService.findPersonById(id);
    }

    @Path("people")
    @GET
    public List<Person> getPeople() {
        return personService.getPeople();
    }

}
