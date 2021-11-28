package edu.matc.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import edu.matc.entity.User;
import edu.matc.persistence.UserData;
import edu.matc.util.PropertiesLoader;

import java.util.ArrayList;
import java.util.List;


@Path("/searchUser")
public class SearchUsersService implements PropertiesLoader {
    UserData userData = new UserData();

    @GET
    @Path("/{param}")
    @Produces("text/html")
    public Response getParamUser(@PathParam("param") String userName) {
        String output = "<html><h1>Hello : " + userData.getUsersByLastName(userName) + "</h1></html>";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Produces("text/html")
    public Response getSingleUser() {
        List<User> users = userData.getAllUsers();
        String output = "<html>" + users + "</html>";
        return Response.status(200).entity(output).build();
    }
}