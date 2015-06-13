package com.soa_study.service;



import com.soa_study.model.Student;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Stateless
@WebService
public class HelloWorldStudent {
    @WebMethod
    public String hello(@WebParam(name="userName") String name){
        return "Witam " + name + "!";
    }

    @WebMethod
    public Student getStudent(@WebParam(name="studentName") String name,
                              @WebParam(name="studentSurname") String surname,
                              @WebParam(name="studentPesel") String pesel){
        Student s = new Student();
        s.setPesel(pesel);
        s.setFirstName(name);
        s.setLastName(surname);
        String[] subjects = {"SOA", "Logika", "PSI"};
        s.setSubjects(Arrays.asList(subjects));
        return s;
    }

    @WebMethod
    @XmlElementWrapper(name="Students")
    @XmlElement(name="student")
    public List<Student> getStudentList(@WebParam(name="Lista")String pesel){
        List <Student> students = new ArrayList<Student>();
        students.add(getStudent("Paweł","Jaroch","92080711457"));
        students.add(getStudent("Kamil","Kusal","92070931234"));
        students.add(getStudent("Monika","Jaroch","95112812313"));
        return students;

    }
}
