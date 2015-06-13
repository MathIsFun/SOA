package pl.agh.edu.kis.soa.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Pawel on 05.05.15.
 */
public class Student {

    String firstName;
    String lastName;
    String albumNo;
    String pesel;


    List<String> subjects;

    public Student(String fN, String lN, String aN, String p) {
        firstName = fN;
        lastName = lN;
        albumNo = aN;
        pesel = p;
    }

    public Student() {

    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subject) {
        this.subjects = subject;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAlbumNo() {
        return albumNo;
    }

    public void setAlbumNo(String albumNo) {
        this.albumNo = albumNo;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }


}
