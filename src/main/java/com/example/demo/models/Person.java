package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    private String secondName;
    private String firstName;
    private String patronymicName;
    private String serialDocument;
    private String numberDocument;
    @JoinColumn(name = "document_person", referencedColumnName = "id")
    @ManyToOne
    private Document document;

    public Person(String secondName, String firstName, String patronymicName, String serialDocument, String numberDocument, Document document) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.patronymicName = patronymicName;
        this.serialDocument = serialDocument;
        this.numberDocument = numberDocument;
        this.document = document;
    }
}
