package com.soa_study.model;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.List;


public class Student implements Serializable {

    private static final long serialVersionUID = -2470020097227629427L;
    String firstName;
    String lastName;
    String albumNo;
    String pesel;


    List<String> subjects;

    public Student() {
    }

    @XmlElementWrapper(name = "subjectsList")
    @XmlElement(name = "subject")
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
