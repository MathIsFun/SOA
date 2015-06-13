
package com.soa_study.main;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soa_study.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetStudentList_QNAME = new QName("http://service.soa_study.com/", "getStudentList");
    private final static QName _GetStudent_QNAME = new QName("http://service.soa_study.com/", "getStudent");
    private final static QName _SayHello_QNAME = new QName("http://service.soa_study.com/", "sayHello");
    private final static QName _SayHelloResponse_QNAME = new QName("http://service.soa_study.com/", "sayHelloResponse");
    private final static QName _GetStudentResponse_QNAME = new QName("http://service.soa_study.com/", "getStudentResponse");
    private final static QName _GetStudentListResponse_QNAME = new QName("http://service.soa_study.com/", "getStudentListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soa_study.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetStudentListResponse }
     * 
     */
    public GetStudentListResponse createGetStudentListResponse() {
        return new GetStudentListResponse();
    }

    /**
     * Create an instance of {@link GetStudent }
     * 
     */
    public GetStudent createGetStudent() {
        return new GetStudent();
    }

    /**
     * Create an instance of {@link GetStudentList }
     * 
     */
    public GetStudentList createGetStudentList() {
        return new GetStudentList();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link GetStudentResponse }
     * 
     */
    public GetStudentResponse createGetStudentResponse() {
        return new GetStudentResponse();
    }

    /**
     * Create an instance of {@link Student.SubjectsList }
     * 
     */
    public Student.SubjectsList createStudentSubjectsList() {
        return new Student.SubjectsList();
    }

    /**
     * Create an instance of {@link GetStudentListResponse.Students }
     * 
     */
    public GetStudentListResponse.Students createGetStudentListResponseStudents() {
        return new GetStudentListResponse.Students();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soa_study.com/", name = "getStudentList")
    public JAXBElement<GetStudentList> createGetStudentList(GetStudentList value) {
        return new JAXBElement<GetStudentList>(_GetStudentList_QNAME, GetStudentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soa_study.com/", name = "getStudent")
    public JAXBElement<GetStudent> createGetStudent(GetStudent value) {
        return new JAXBElement<GetStudent>(_GetStudent_QNAME, GetStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soa_study.com/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soa_study.com/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soa_study.com/", name = "getStudentResponse")
    public JAXBElement<GetStudentResponse> createGetStudentResponse(GetStudentResponse value) {
        return new JAXBElement<GetStudentResponse>(_GetStudentResponse_QNAME, GetStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soa_study.com/", name = "getStudentListResponse")
    public JAXBElement<GetStudentListResponse> createGetStudentListResponse(GetStudentListResponse value) {
        return new JAXBElement<GetStudentListResponse>(_GetStudentListResponse_QNAME, GetStudentListResponse.class, null, value);
    }

}
