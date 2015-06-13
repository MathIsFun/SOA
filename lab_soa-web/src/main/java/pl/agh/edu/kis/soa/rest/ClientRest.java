package pl.agh.edu.kis.soa.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import pl.agh.edu.kis.soa.rest.model.Student;
import sun.misc.BASE64Encoder;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Pawel on 01.06.15.
 */
public class ClientRest {

    private static Logger logger = Logger.getLogger("ClientRest");

    public static void main(String args[]) {
        try {
            Gson g = new Gson();

             /* Przykladowi studenci */
            ArrayList<Student> studentList = new ArrayList<>();
            Student s1 = new Student("Pawel", "Jaroch", "1234", "53241");
            Student s2 = new Student("Kamil", "Kowalski", "4321", "78657");
            Student s3 = new Student("Andrzej", "Student", "9876", "45322");
        //    Student s4 = new Student("Kamil", "Kowalski", "4321", "78657");

            studentList.add(s1);
            studentList.add(s2);
            studentList.add(s3);
        //    studentList.add(s4);

            URL url = new URL("http://localhost:8080/lab_soa-web/test/student");
            String input;
            OutputStream os;
            HttpURLConnection conn = null;
            /* POST */
            System.out.println("POST");
            for (int i = 0; i < studentList.size(); i++) {

                conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");

                input = g.toJson(studentList.get(i));
                os = conn.getOutputStream();
                os.write(input.getBytes());
                os.flush();

                printOutput(conn);

            }

           /* GET */
            System.out.println("GET");
            url = new URL("http://localhost:8080/lab_soa-web/test/student?id=1234");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            printOutput(conn);

            /* PUT */
            System.out.println("PUT");
            url = new URL("http://localhost:8080/lab_soa-web/test/student?id=1234");
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");

            input = g.toJson(studentList.get(0));

            os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            printOutput(conn);

            /* Autoryzacja */


            System.out.println("Autoryzacja");
            CookieHandler.setDefault( new CookieManager( null, CookiePolicy.ACCEPT_ALL ) );
            try {

                url = new URL("http://localhost:8080/lab_soa-web/test/authorize?login=user&password=password");
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", "application/json");
               // conn.setDoOutput(true);

                conn.connect();
                int status = conn.getResponseCode();
                logger.log(Level.INFO, "Authorization status: " + status);
                if (status == 200) {
                    URL u2 = new URL("http://localhost:8080/lab_soa-web/test/secureHello");
                    conn = (HttpURLConnection) u2.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.connect();
                    status = conn.getResponseCode();
                    logger.log(Level.INFO, "Secure resource status: " + status);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void printOutput(HttpURLConnection conn) throws IOException {
        String output;
        BufferedReader br;
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
    }
}
