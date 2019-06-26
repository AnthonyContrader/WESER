package it.contrader.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Cure.
 */
@Entity
@Table(name = "cure")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Cure implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cf")
    private String cf;

    @Column(name = "age")
    private Integer age;

    @Column(name = "pato")
    private String pato;

    @Column(name = "carename")
    private String carename;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "notes")
    private String notes;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Cure name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCf() {
        return cf;
    }

    public Cure cf(String cf) {
        this.cf = cf;
        return this;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public Integer getAge() {
        return age;
    }

    public Cure age(Integer age) {
        this.age = age;
        return this;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPato() {
        return pato;
    }

    public Cure pato(String pato) {
        this.pato = pato;
        return this;
    }

    public void setPato(String pato) {
        this.pato = pato;
    }

    public String getCarename() {
        return carename;
    }

    public Cure carename(String carename) {
        this.carename = carename;
        return this;
    }

    public void setCarename(String carename) {
        this.carename = carename;
    }

    public String getQuantity() {
        return quantity;
    }

    public Cure quantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNotes() {
        return notes;
    }

    public Cure notes(String notes) {
        this.notes = notes;
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cure cure = (Cure) o;
        if (cure.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), cure.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Cure{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", cf='" + getCf() + "'" +
            ", age=" + getAge() +
            ", pato='" + getPato() + "'" +
            ", carename='" + getCarename() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}
