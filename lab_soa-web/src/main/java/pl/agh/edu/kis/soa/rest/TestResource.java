package pl.agh.edu.kis.soa.rest;

import com.google.gson.Gson;
import pl.agh.edu.kis.soa.rest.model.Student;


import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Pawel on 05.05.15.
 */

@Stateless
@Path("test")
public class TestResource {
    private static final String LOGIN_KEY = "user";
    private HashMap<String, Student> listStudents = new HashMap<>();
    private static Logger logger = Logger.getLogger("TestResource");
    private static final String PDF_FILE = "D:\\ProtocolBuffers.pdf";
    private static final String PNG_FILE = "D:\\Travel_use_case.png";

    @GET
    @Path("student/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(@PathParam("id") String albumNo) {
        logger.info("heloo invoked, param1=" + albumNo);
        Student s = listStudents.get(albumNo);
        return Response.ok(s, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("student")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("id") String id) {

        Student s = listStudents.get(id);
        return Response.ok(s, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("student")
   // @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(Student s) {

        if (listStudents.get(s.getAlbumNo()) != null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else {
            listStudents.put(s.getAlbumNo(), s);
            return Response.ok(s, MediaType.APPLICATION_JSON).build();
        }

    }


    @PUT
    @Path("student")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudent(@QueryParam("id") String albumNo, Student student) {
        Iterator it = listStudents.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry actualStudent = ((Map.Entry<String, Student>) it.next());
            if (actualStudent.getKey().equals(albumNo)) {
                String[] subjects = {"SOA", "PSI", "Hurtownie"};
                student.setSubjects(Arrays.asList(subjects));
                listStudents.put(actualStudent.getKey().toString(), student);
                return Response.ok(listStudents.get(student.getAlbumNo()), MediaType.APPLICATION_JSON).build();
            }
        }

        listStudents.put(albumNo, student);
        return Response.ok(listStudents.get(student.getAlbumNo()), MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("student")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudent(@QueryParam("id") String id){
        listStudents.remove(id);
        return Response.ok(listStudents.get(id), MediaType.APPLICATION_JSON).build();

    }

    @GET
    @Path("pdf")
    @Produces("application/pdf")
    public Response getPDF() {

        File file = new File(PDF_FILE);
        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=\"test_PDF_file.pdf\"");
        return response.build();

    }

    @GET
    @Path("png")
    @Produces("application/png")
    public Response getPNG() {

        File file = new File(PNG_FILE);
        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=\"test_PNG_file.png\"");
        return response.build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("authorize")
    public Response authorize(@QueryParam("login") String login, @QueryParam("password") String password, @Context HttpServletRequest request) {
        logger.info(String.format("%s", "authorize invoked, login: " + login));
        HttpSession httpSession = request.getSession();
        if (httpSession == null) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        if (password.equals("password")) {
            httpSession.setAttribute(LOGIN_KEY, login);
            return Response.ok().build();
        } else {
            httpSession.setAttribute(LOGIN_KEY, null);
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

        @GET
        @Path("secureHello")
        @Produces(MediaType.APPLICATION_JSON)
        public Response hello(@QueryParam("id") String id, @Context HttpServletRequest request) {
            logger.info(String.format("hello invoked, id = %s", id));
            HttpSession session = request.getSession();
            String login = (String) session.getAttribute(LOGIN_KEY);
            if(session == null) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
            if(login != null) {
                Student s = new Student("Jaroch","Pawel", id, "92051862536");
                return Response.ok(s, MediaType.APPLICATION_JSON).build();
            }
            return Response.status(Response.Status.FORBIDDEN).build();
        }

}