package com.alfilsoft.model;
// default package
// Generated Jul 9, 2018 4:19:10 PM by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Tblrol generated by hbm2java
 */
@Entity
@Table(name = "TBLROL")
public class Rol implements java.io.Serializable {

    private Long id;
    private String name;
    private String permissions;

    public Rol() {
    }

    public Rol(Long id) {
        this.id = id;
    }

    public Rol(Long id, String name, String permissions) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_id_seq")
    @SequenceGenerator(name = "rol_id_seq", sequenceName = "TBLROL_ID_SEQ")
    @Column(name = "SECROL", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME", length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "PERMISSIONS", length = 300)
    public String getPermissions() {
        return this.permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

}