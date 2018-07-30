package com.ust.datasource.api;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@XmlRootElement
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;
    private String email;
    private String salary;
    private String dni;
    private String fecnac;
    private String direccion;
    private String ctacte;
    private String estadocivil;
    private String sexo;
    private String fecalta;
    private String categoria;
    private String tipocontrato;
    private String nsegsoc;
    private String numtel;
    private String fecbaja;

}
