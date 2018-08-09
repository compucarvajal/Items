package com.alfilsoft.model;
// default package
// Generated Jul 9, 2018 4:19:10 PM by Hibernate Tools 5.0.6.Final

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tblshop generated by hbm2java
 */
@Entity
@Table(name = "TBLSHOP")
public class Shop implements java.io.Serializable {

    private Long id;
    private Date creationDate;
    private String idRepresentative;
    private String representative;
    private String shopName;
    private String nit;
    private String personType;
    private String shortName;
    private List<Bill> billList;
    private String email;

    public Shop() {
    }

    public Shop(Long id) {
        this.id = id;
    }

    public Shop(Date creationDate, String idRepresentative, String representative, String shopName,
            String nit, String personType) {
        this.creationDate = creationDate;
        this.idRepresentative = idRepresentative;
        this.representative = representative;
        this.shopName = shopName;
        this.nit = nit;
        this.personType = personType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_id_seq")
    @SequenceGenerator(name = "shop_id_seq", sequenceName = "TBLSHOP_ID_SEQ")
    @Column(name = "SECSHOP", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE", length = 23)
    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "ID_REPRESENTATIVE", length = 15)
    public String getIdRepresentative() {
        return this.idRepresentative;
    }

    public void setIdRepresentative(String idRepresentative) {
        this.idRepresentative = idRepresentative;
    }

    @Column(name = "REPRESENTATIVE", length = 200)
    public String getRepresentative() {
        return this.representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    @Column(name = "SHOP_NAME", length = 200)
    public String getShopName() {
        return this.shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Column(name = "NIT", length = 20)
    public String getNit() {
        return this.nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Column(name = "PERSON_TYPE", length = 2)
    public String getPersonType() {
        return this.personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    @Column(name = "SHORT_NAME")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonIgnoreProperties
    @OneToMany(mappedBy = "shop", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
